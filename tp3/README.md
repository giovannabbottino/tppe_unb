# TRABALHO PRATICO 3

## Boa documentação

### Descrição: 
Uma boa documentação deve ser orgânica, pois, ela deve acompanhar a evolução do software. Documentar um software é transcrever informações que não são implícitas ao produto de software, a documentação pode ser realizada para todos os níveis do software, tanto documentar o que código-fonte do software quanto para documentar os requisitos e a arquitetura utilizada definida para cada projeto.

### Relação com maus cheiros: 
- Comentários: Um bom código deve ser simples e fácil de entender, documentá-lo com comentários pode auxiliar, porém, o ideal é que um código seja bem organizado a ponto do programador não necessitar ler um comentário para entender o funcionamento. 
- Mudanças divergentes: Quando uma mudança de regra de negócio ocorre, o comportamento de determinadas funcionalidades e classes mudam, e essas regras de negócio se não forem acompanhadas na documentação de cada funcionalidade podem prejudicar a refatoração do software no futuro, já que não há um alinhamento entre a documentação e o produto implementado.

### Operação de refatoração:
Ao evoluir um projeto de código, é necessário atualizar toda a documentação realizada para refletir o comportamento do software. Diagramas, esquemas e desenhos não devem ser estáticos, eles devem abstrair as mudanças das regras de negócio e espelhar nos documentos criados.
	

## Simplicidade

### Descrição:
Para software, simplicidade significa um código que é fácil de ler, entender e modificar.
A simplicidade é principalmente um fator humano. Quando o código segue esta característica a estrutura do código fica mais simples, a claridade e a coesão é maior.

### Relação com maus cheiros: 
Esta característica tem uma relação com os maus-cheiros: 
- Código duplicado: Quando um trecho de código aparece em vários lugares do projeto, o código começa a ficar mais complicado e perder a simplicidade.
- Método longo: Quanto maior for o tamanho do método, maior é a dificuldade de entendê-lo.
- Classe grande: Quanto maior a classe, mais difícil é de entender a sua funcionalidade.

 
### Operação de refatoração:
- Extrair método: Com esta operação o método fica menor, e consequentemente mais simples.
- Renomear variável: Operação que transforma o nome da variável, para ficar mais fácil e simples de entender.

## Idiomático 

### Descrição: 
Idiomático está fortemente vinculado a claridade e coesão do código. Isso porque ler um código deve ser como ler uma história, você deve compreender as convenções de nomenclatura e expressões idiomáticas. Algumas linguagens têm uma convenção de nomenclatura comum. Seguir essas metodologias de design permite que outros programadores entendam imediatamente a estrutura do código que diminuiu a curva de aprendizado e erros.
### Relação com mau cheiro: 
Diferente de outras características, idiomático não possui uma relação forte aos maus-cheiros apresentados por Fowler, mas não fazer um código idiomático pode levar a pontos de refatoração. Como, por exemplo, código duplicado ou método longo, em que um código pode aparecer várias vezes de diferentes formas no projeto ou métodos longos de difícil compreensão. 
### Operação de refatoração: 
Nesses casos, pode-se usar as operações de refatoração: extrair objeto, substituir método por método-objeto e outros, dependendo do caso. 

## Ausência de duplicidades

### Descrição:
Como o nome já diz, essa característica se refere a um código bem projetado para evitar código duplicado. Um projeto que não possui código duplicado é mais manutenível e mais seguro, pois, evita possíveis problemas causados por modificações em um trecho de código, mas não em suas “duplicatas”.
### Relação com mau cheiro: 
Código duplicado: Quando um trecho de código aparece em vários lugares do projeto.
### Operação de refatoração: 
Extrair método: Trechos de códigos muito similares ou duplicados podem ser extraídos para uma função com os parâmetros adequados.

## Extensibilidade

### Descrição: 
Um bom design de código permite funcionalidades extras a serem adicionadas em locais apropriados quando necessário. Só é necessário tomar cuidado para não causar problemas futuros de evolução no código. Um exemplo de extensibilidade seria hierarquia de código de classes que possuem sua interface implementada, ou fornecer funções com callbacks úteis, e até mesmo a estrutura do código for lógica e maleável.
### Relação com maus cheiros:
- Métodos Longos: ao possuir métodos muitos longos influência na estrutura do código lógica dificultando a extensibilidade
- Campo temporário: ao utilizar campos temporários dificulta a extensibilidade partindo de uma interface, pois  pode-se desconhecer esses campos temporários causando confusão e dificuldade.
- Cadeia de Mensagem: Ao estender um método que possui esse mau-cheiro, não se sabe onde estará afetando ao certo.
- Herança negada: Ao estender uma classe que possui esse mal-cheiro e os dados herdados do pai são desnecessários, assim o problema será propagado.

### Operação de refatoração:
- Métodos Longos: 
	- Extrair método: sempre que necessário diminuir o tamanho de um método. 
- Campo temporário:
	- Extrair classe: para criar um local onde as variáveis temporárias serão armazenadas. 
- Cadeia de Mensagem:
	- Ocultar delegação: pode causar indireção indesejada. 
	- Extrair método / mover método: extrair o trecho de código que é utilizado pelo cliente e movê-lo para pontos iniciais da cadeia. 
- Herança negada:
	- Descer método / campo: para mover os métodos e campos inutilizados para uma classe irmã daquela que está rejeitando a herança. 
	- Substituir herança por delegação: quando a subclasse não quer herdar a implementação de uma interface realizada por sua superclasse. 