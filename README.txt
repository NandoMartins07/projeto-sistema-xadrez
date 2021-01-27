	No curso de Programação de Computadores 2 - Programação Orientada a Objeto usando a linguagem Java, tive a oportunidade
de obter os conhecimentos inicias sobre o assunto atraves das aulas a distância ministaradas pelo professor Gustavo Pinto.
Nas aulas foram abordados os temas classe, objeto, herança, encapsulamento, polimorfismo, coleções e tramento de exceções,
como também foram realizados exercicios para a prática do conteudo ministado nas aulas.
	Como parte final da avaliação foi proposto o desenvolvimento de um projeto que contempla todo o conteúdo repassado 
referênte a programação orientada a obejto.
	Assim, resolvir criar a mecânica geral de um jogo de xadrez, levando em consideração meu recente interesse pela 
prática, achei uma boa ideia, já que iria unir o util ao agradável.
	É um jogo simples, que pode ser jogado atraves de um terminal. Com o projeto pude aprender mais sobre origentação
a objeto usando java, boas práticas de programação, tratamento de erro, versionamento de código, correção de bugs e 
logíca de programação.
	O código e os commit foram desenvolvios em português, o que em certo ponto passou a ser uma dificuldade devido na 
lingua portuguêsa as palavras serem muito extensas.
	Levei alguns dias para terminar o projeto, ainda mais porque tive um problema no meu primeiro repositório, comecei o 
projeto usando um notebook, quando fui baixar do github para um outro computador, os arquivos não vinham. Então criei um outro
repositôrio e tive que recomeçar a partir dele, porém aproveitando os códigos já escritos anteriormente. Abaixo segue o
link dos dois repositórios:
>> https://github.com/NandoMartins07/sistema-xadrez/tree/master (repositorio que deu problema)
>> https://github.com/NandoMartins07/projeto-sistema-xadrez (repositorio funcionando)

Agora explicando um pouco sobre o jogo.

	A mecânica do jogo se baseia em lihas (1,2,3,4,5,6,7,8) e colunas (a,b,c,d,e,f,g,h) e as peças são as inciais das 
mesmas em português, apenas a rainha foi denominada de Dama(D) devido a letra R já ser usada para o Rei.
Peças:
Peão 	--> P
Torre 	--> T
Cavalo  --> C
Bispo 	--> B
Dama 	--> D
Rei 	--> R

	O jogo ainda conta com a previção de movimento das peças, sendo as casas para onde a peça pode se mover marcadas em azul.
Como as IDEs possuem fundo preto, as peças pretas foram representadas pela cor amarelo. Por isso é recomendado
utilizar o terminal do git bash que possui uma interface colorida e poderá ver as peças de amarelo e as casas de possivel
movimento das peças. Também quando uma peça é captura, é possivel vê-la abaixo do tabuleiro em "Pecas capturadas".

Para iniciar o jogo é necessario ir até a pasta/repositorio e executar o terminal do git bash na pasta .bin
(...\projeto-sistema-xadrez\bin). Com o terminal aberto deve digitar o seguinte comando: java aplicacao/programa.

Explicando a interface:

* Pecas capturadas: armazena as peças capturadas pelos dois jogadores.
* Turno: exibe o turno ou rodada em que o jogo está, somando os dois jogadores.
* Esperando o jogador (Branca/Preta) : exibe qual é o jogador a mover a peça naquele turno.
* Origem: peça que deseja mover, escrita em coordenadas.
* Destino: local no qual o jogador deseja colocar a peça, escrita em coordenada.
* Check: aparece quando coloca um dos reis em cheque.
* CheckMate: o rei ficou sem possibilidade de movimento, fim do jogo.

	O jogo começa com as peças brancas e para escolher uma peça que deseja mover é necessário digitar as coordenadas 
(linha e coluna), por exemplo, para mover o primeiro peão branco é só digitar a2 para selecionar e depois a4 para 
mover a peça para a casa de destino.
	Se por algum acaso a coordenada seja inválida ou jogada impossível, irá aparecer uma mensagem de erro bastando a
pertar ENTER para recomeçar a jogada. Também quando for feita uma jogada que gera uma situação de Check ou CheckMate, será 
presentado uma mensagem na tala avisando, sendo obrigado a tirar o rei da posição de ameça, capiturando a peça do 
adversário ou movendo o rei.
	Pretendo implementar algumas jogadas especiais, mas ainda estou formulando a lógica, o que parece ser um pouco 
complicado, visto que devo antes entender como a jogada acontece.