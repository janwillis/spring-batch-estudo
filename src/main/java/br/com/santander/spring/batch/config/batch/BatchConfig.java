package br.com.santander.spring.batch.config.batch;


import br.com.santander.spring.batch.services.PessoaService;
import io.micrometer.common.lang.Nullable;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.time.LocalDate;


@Configuration
@EnableBatchProcessing(
        dataSourceRef = "mysqlDataSource",
        transactionManagerRef = "mysqlTransactionManager",
        tablePrefix = "BATCH_.",
        maxVarCharLength = 1000
//        isolationLevelForCreate = "READ_COMMITTED"
)
public class BatchConfig {





}
