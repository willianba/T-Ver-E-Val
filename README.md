# Verificação e Validação de Software I

## Prof. Bernardo Copstein

### Integrantes: David Bertrand, Guilherme Carvalho, Matheus Tosin e Willian Alves

---

## Relatório 
O presente documento tem por objetivo aplicar as Técnicas e Ferramentas apresentadas em aula no trabalho proposto na disciplina de Verificação e Validação de Software I.

## Enunciado do problema

O enunciado do problema consiste em identificar os casos de teste possíveis para um sistema de vendas que possuí algumas classes alvos. As classes contêm regras de negócios onde possuem métodos que deverão ser validadas com as técnicas de testes.

## Estrutura das classes

A estrutura de classe pode ser dividida em três classes principais:

- ServicoDeVendas: classe central que implementa as interfaces Estoque e Produtos;
- FactoryValidacao: implementada pelas classes ValidacaoForaHorarioComercial e ValidacaoHorarioComercial;
- Interface RegraImposto: implementada pelas classes RegraImpostoComprasGrandes RegraImpostoOriginal.

## Testes

Neste trabalho não foi construído os Casos de Testes. Porém para cada caso foi utilizado técnicas diferentes e foi construído direto nos drivers.

Os próximos itens deste relatório apresentarão as técnicas aplicadas em cada classe
Ex.: Classe: método().

### Teste unitário
 - ServicoDeVendas: todos os métodos da classe;
- ValidacaoForaHorarioComercial:  validaTresProdutosExistentes();
- ValidacaoHorarioComercial: validaTresProdutosExistentes().

### Teste parametrizado
- FactoryValidacaoTest: retornaValidacao();
- RegraImpostoComprasGrandes: calculaDezPorcento();
- RegraImpostoOriginal: calculaDezPorcento();
- ValidacaoForaHorarioComercial: validaExcecoes();
- ValidacaoHorarioComercial: validaExcecoes().

## Ferramentas
### Mockito 
- ServicoDeVendasTest: todos os métodos da classe;
- ValidacaoForaHorarioComercial: todos os métodos da classe;
- ValidacaoHorarioComercial: todos os métodos da classe.

### Sonarcloud
IMAGE

## Cobertura de código

A imagem acima, no item Sonarcloud, mostra um resultado final de 95% de coverage. Este resultado se dá devido ao fato de não ter sido realizado os testes dos gettes e setters das classes.

## Análise das técnicas e ferramentas utilizadas

Para inferir a opinião do grupo, será necessário expor o que foi feito para gerar os testes do trabalho proposto. Segue abaixo:
- Remoção de visibilidade publica dos testes, porque o Junit 5 já abrange isso
- Remoção do código duplicado das classes de validação -> implementado o padrão de Form Template Method (https://refactoring.guru/form-template-method)
- Trocamos as chamadas de métodos explicitas nos lambdas por inferência de métodos;
- Implementação do Sonarcloud: https://sonarcloud.io/dashboard?id=matheustosin_TF-Ver-E-Val
Referente as outras ferramentas, foi utilizado, como o padrão do T1 das disciplina, um *plugin* junto com o `Maven`, o `jacoco`, no qual permite acompanhar e gerar relatórios de cobertura de código da nossa classe alvo.

No geral, com base de que cada conjunto de classes usamos técnicas diferentes, podemos concluir que conseguimos cobrir 100% da aplicação onde foram realizados os testes unitários. Usamos Junit 5, Mockito e exploramos alguns testes parametrizados onde vimos que seria possível aplicar, atendendo as expectativas do esperado.
Referente ao Sonarcloud, se trata de uma ferramenta muito boa pra análise estática de código, porém o único contraponto é que não suporta análise automática com Java. Então a gente precisou rodar um comando no Maven sempre que queríamos realizar um Scan. 
