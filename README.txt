	No curso de Programa��o de Computadores 2 - Programa��o Orientada a Objeto usando a linguagem Java, tive a oportunidade
de obter os conhecimentos inicias sobre o assunto atraves das aulas a dist�ncia ministaradas pelo professor Gustavo Pinto.
Nas aulas foram abordados os temas classe, objeto, heran�a, encapsulamento, polimorfismo, cole��es e tramento de exce��es,
como tamb�m foram realizados exercicios para a pr�tica do conteudo ministado nas aulas.
	Como parte final da avalia��o foi proposto o desenvolvimento de um projeto que contempla todo o conte�do repassado 
refer�nte a programa��o orientada a obejto.
	Assim, resolvir criar a mec�nica geral de um jogo de xadrez, levando em considera��o meu recente interesse pela 
pr�tica, achei uma boa ideia, j� que iria unir o util ao agrad�vel.
	� um jogo simples, que pode ser jogado atraves de um terminal. Com o projeto pude aprender mais sobre origenta��o
a objeto usando java, boas pr�ticas de programa��o, tratamento de erro, versionamento de c�digo, corre��o de bugs e 
log�ca de programa��o.
	O c�digo e os commit foram desenvolvios em portugu�s, o que em certo ponto passou a ser uma dificuldade devido na 
lingua portugu�sa as palavras serem muito extensas.
	Levei alguns dias para terminar o projeto, ainda mais porque tive um problema no meu primeiro reposit�rio, comecei o 
projeto usando um notebook, quando fui baixar do github para um outro computador, os arquivos n�o vinham. Ent�o criei um outro
reposit�rio e tive que recome�ar a partir dele, por�m aproveitando os c�digos j� escritos anteriormente. Abaixo segue o
link dos dois reposit�rios:
>> https://github.com/NandoMartins07/sistema-xadrez/tree/master (repositorio que deu problema)
>> https://github.com/NandoMartins07/projeto-sistema-xadrez (repositorio funcionando)

Agora explicando um pouco sobre o jogo.

	A mec�nica do jogo se baseia em lihas (1,2,3,4,5,6,7,8) e colunas (a,b,c,d,e,f,g,h) e as pe�as s�o as inciais das 
mesmas em portugu�s, apenas a rainha foi denominada de Dama(D) devido a letra R j� ser usada para o Rei.
Pe�as:
Pe�o 	--> P
Torre 	--> T
Cavalo  --> C
Bispo 	--> B
Dama 	--> D
Rei 	--> R

	O jogo ainda conta com a previ��o de movimento das pe�as, sendo as casas para onde a pe�a pode se mover marcadas em azul.
Como as IDEs possuem fundo preto, as pe�as pretas foram representadas pela cor amarelo. Por isso � recomendado
utilizar o terminal do git bash que possui uma interface colorida e poder� ver as pe�as de amarelo e as casas de possivel
movimento das pe�as. Tamb�m quando uma pe�a � captura, � possivel v�-la abaixo do tabuleiro em "Pecas capturadas".

Para iniciar o jogo � necessario ir at� a pasta/repositorio e executar o terminal do git bash na pasta .bin
(...\projeto-sistema-xadrez\bin). Com o terminal aberto deve digitar o seguinte comando: java aplicacao/programa.

Explicando a interface:

* Pecas capturadas: armazena as pe�as capturadas pelos dois jogadores.
* Turno: exibe o turno ou rodada em que o jogo est�, somando os dois jogadores.
* Esperando o jogador (Branca/Preta) : exibe qual � o jogador a mover a pe�a naquele turno.
* Origem: pe�a que deseja mover, escrita em coordenadas.
* Destino: local no qual o jogador deseja colocar a pe�a, escrita em coordenada.
* Check: aparece quando coloca um dos reis em cheque.
* CheckMate: o rei ficou sem possibilidade de movimento, fim do jogo.

	O jogo come�a com as pe�as brancas e para escolher uma pe�a que deseja mover � necess�rio digitar as coordenadas 
(linha e coluna), por exemplo, para mover o primeiro pe�o branco � s� digitar a2 para selecionar e depois a4 para 
mover a pe�a para a casa de destino.
	Se por algum acaso a coordenada seja inv�lida ou jogada imposs�vel, ir� aparecer uma mensagem de erro bastando a
pertar ENTER para recome�ar a jogada. Tamb�m quando for feita uma jogada que gera uma situa��o de Check ou CheckMate, ser� 
presentado uma mensagem na tala avisando, sendo obrigado a tirar o rei da posi��o de ame�a, capiturando a pe�a do 
advers�rio ou movendo o rei.
	Pretendo implementar algumas jogadas especiais, mas ainda estou formulando a l�gica, o que parece ser um pouco 
complicado, visto que devo antes entender como a jogada acontece.