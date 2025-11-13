//package br.com.santander.spring.batch.controller;
//
//
//import io.micrometer.common.lang.Nullable;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.StepContribution;
//import org.springframework.batch.core.job.builder.JobBuilder;
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.batch.core.scope.context.ChunkContext;
//import org.springframework.batch.core.step.builder.StepBuilder;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping(path = "/teste" )
//public class Teste {
//
//    private final JobRepository JobRepository;
//
//    PlatformTransactionManager jobRepository
//    //
//    public Teste(JobRepository JobRepository) {
//        this.JobRepository = JobRepository;
//    }
//
//    @GetMapping(path = "/exibe")
//    Long exibe(){
//        imprimeJob(this.jobRepository);
//        return 3423423L;
//    }
//
//
//
//
//    //
//    public Job imprimeJob(JobRepository , Step imprimeOlaStep) {
//        return new JobBuilder("imprimeJob", jobRepository)
//                .start(imprimeOlaStep)
//                .build();
//    }
//
//    public Step imprimeOlaStep(PlatformTransactionManager transactionManager) {
//        return new StepBuilder("imprimeOlaStep", JobRepository)//
//                .tasklet(getTasklet(),transactionManager)//
//                .build();
//    }
//
//    public Tasklet getTasklet() {
//        return new Tasklet() {
//            @Override
//            public @Nullable RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//                System.out.println(32432423 % 3);
//                return RepeatStatus.FINISHED;
//            }
//        };
//    }
//
//}
