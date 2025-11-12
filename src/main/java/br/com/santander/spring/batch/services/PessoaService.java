package br.com.santander.spring.batch.services;


import br.com.santander.spring.batch.domain.entity.mysql.Pessoa;
import br.com.santander.spring.batch.repository.mysql.PessoaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {


    private ModelMapper modelMapper;


    private PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
            }


          public  void createPessoa(Pessoa pessoa){
              pessoaRepository.save(pessoa);
            }

}
