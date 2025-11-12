//package br.com.santander.spring.batch.config;
//
//
//import br.com.santander.spring.batch.domain.entity.mysql.Pessoa;
//import br.com.santander.spring.batch.services.PessoaService;
//import org.jspecify.annotations.Nullable;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.job.Job;
//import org.springframework.batch.core.job.builder.JobBuilder;
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
//import org.springframework.batch.core.scope.context.ChunkContext;
//import org.springframework.batch.core.step.Step;
//import org.springframework.batch.core.step.StepContribution;
//import org.springframework.batch.core.step.builder.StepBuilder;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.infrastructure.repeat.RepeatStatus;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.sql.DataSource;
//import java.time.LocalDate;
//
//@EnableBatchProcessing
//@Configuration
//public class BatchConfig {
//
////    private final JobRepository jobRepository;
//
//
//    private final PessoaService pessoaService;
//
//    public BatchConfig(PessoaService pessoaService) {
////        this.jobRepository = jobRepository;
//        this.pessoaService = pessoaService;
//    }
//
//
//    @Bean
//     public PlatformTransactionManager transactionManager(DataSource dataSource){
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean
//    public JobRepository jobRepository(DataSource dataSource, PlatformTransactionManager transactionManager) {
//        JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
//        factory.setDataSource(dataSource);
//        factory.setTransactionManager(transactionManager);
//        return factory.getObject();
//    }
//
//    @Bean
//    public Job imprimeJob(JobRepository jobRepository, Step imprimeOlaStep) {
//        return new JobBuilder("imprimeJob", jobRepository)
//                .start(imprimeOlaStep)
//                .build();
//    }
//
//    @Bean
//    public Step imprimeOlaStep(PlatformTransactionManager transactionManager) {
//        return new StepBuilder("imprimeOlaStep", jobRepository)//
//                .tasklet(getTasklet(),transactionManager)//
//                .build();
//    }
//
//    @Bean
//    public   Tasklet getTasklet() {
//        return new Tasklet() {
//            @Override
//            public @Nullable RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//                System.out.println(32432423 % 3);
//                pessoaService.createPessoa(Pessoa.builder()//
//                                .nome("new Faker.")
//                                .dataNascimento(LocalDate.now())
//                         .build());
//
//
//                return RepeatStatus.FINISHED;
//            }
//        };
//    }
//
//}
