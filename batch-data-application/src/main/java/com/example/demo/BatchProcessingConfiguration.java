package com.example.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Configuration
@EnableBatchProcessing
public class BatchProcessingConfiguration {

    @Bean
    @StepScope //Recreate each time job is run
    FlatFileItemReader<Person> flatFileItemReader(@Value("#{jobParameters[file]}")File file){
        //Read data into type Person Object defined - from file
        FlatFileItemReader<Person> reader = new FlatFileItemReader<>();
        reader.setResource(new FileSystemResource(file));
        reader.setLineMapper(new DefaultLineMapper<Person>() {
            {
                this.setLineTokenizer(new DelimitedLineTokenizer(","){
                    {
                        this.setNames(new String[]{"name", "surname", "email"});
                    }
                });
                this.setFieldSetMapper(new BeanWrapperFieldSetMapper<Person>(){
                    {
                        this.setTargetType(Person.class);
                    }
                });
            }
        });
        return reader;
    }

    @Bean
    JdbcBatchItemWriter<Person> jdbcBatchItemWriter(DataSource h2){
        //writing data of type person out
        JdbcBatchItemWriter<Person> writer = new JdbcBatchItemWriter<>();
        writer.setDataSource(h2);
        writer.setSql("INSERT INTO PEOPLE (name, surname, email) VALUES (:name, :surname, :email)");
        //spring uses this to map values into the named properties above on incoming object.
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        return writer;
    }


    @Bean
    Job personEtl(StepBuilderFactory stepBuilderFactory, JobBuilderFactory jobBuilderFactory,
                  FlatFileItemReader<Person> reader, JdbcBatchItemWriter<Person> writer){
        //create a step
        Step step = stepBuilderFactory.get("file-to-db")
                .<Person, Person>chunk(5)
                .reader(reader)
                .writer(writer)
                .build();

        //create a job
        return jobBuilderFactory.get("person-etl").start(step).build();
    }

    //CommandLineRunner is an interface that springboot calls when the app starts
    @Bean
    CommandLineRunner runner(JobLauncher launcher, Job job, @Value("${file}") File in, JdbcTemplate template){
        return args -> {
            JobExecution execution = launcher.run(job, new JobParametersBuilder()
                    .addString("file", in.getAbsolutePath()).toJobParameters());
            System.out.println("Execution Status: " + execution.getExitStatus());
            List<Person> personList = template.query("select * from PEOPLE", new RowMapper<Person>() {
                @Override
                public Person mapRow(ResultSet rs, int i) throws SQLException {
                    return new Person(rs.getString("name"), rs.getString("surname"),
                            rs.getString("email"));
                }
            });
            personList.forEach(System.out::println);
        };
    }
}
