import static java.lang.System.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Funcoes {
    
    // Exercicio 1
    public void verificarPalindromo() {
        
        System.out.println("Executando verificar palindromo");
        Scanner leitor = new Scanner(in);
        out.println("Digite uma palavra para verificar palindromo");
        String palavra = leitor.nextLine();
        leitor.close();
        // recebendo e armazenando a palavra a ser verificado

        if (ehPalindromo(palavra)) {
            out.println(palavra + " é palindromo");
        } else
            out.println(palavra + " nao e palindromo");
            // fazendo a verificação conforme o resultado do boolean abaixo, se for palindromo ou nao
            
            ehPalindromo(palavra);
        // chama a funçao
    }

    private boolean ehPalindromo(String palavra) {
        int i = 0;
        int j = palavra.length() - 1;
        while (i < j) {
            if (palavra.charAt(i) != palavra.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
        
        // booleano que valida as letras, o i indo pra frente e o j voltando os caracteres, e valida se a primeira é igual a ultima, se a segunda é igual a penultima, e etc...
    }

    // Exercicio 2
    public void ordenaArray(){
        // metodo que ordena arrays, recebe a quantidade de algarismos e faz a verificação devida, instancia o array e solicita os algarismos a serem ordenados, e suas verificações. Na segunda funcao temos dois loops que percorrem o lenght do array, e há a verificação que se o i for maior que o j, eles trocarão de lugar, e no fim um prit refinado do array

        Scanner leitor = new Scanner(in);

        // solicita a quantidade de algarismos do array a ser digitado
        out.println("digite a quantidade de algarismos");
        while(!leitor.hasNextInt()){
            out.println("por favor, digite um numero inteiro, seu animal");
            leitor.next();
            // da um xingao e faz a verificação se o numero digitado é são int ou string
        }
        int tamanho = leitor.nextInt();
        

        // instanciando o array
        int[] numeros = new int[tamanho];
        
        // recebe os numeros que sofrerao a mudança
        out.println("digite uma sequencia de numeros separada por espaço");
        while(!leitor.hasNextInt()){
            out.println("por favor, digite um numero inteiro, seu animal");
            leitor.next();
            //  verificação se o numero digitado é são int ou string
        }
        for(int i = 0; i < tamanho; i++){
            numeros[i] = leitor.nextInt(); 
            // loop para armazenar os numeros digitados,
        }

        // fechando do scanner
        leitor.close();
        
        
        // chamada da função
        funcaoAuxiliar(numeros);
    }
    
    private void funcaoAuxiliar(int[] numeros) {
        // dois loops com uma estrutura de condição que fazem todo o processo de organização numero em ordem crescente
        for (int i = 0; i < numeros.length; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[i] > numeros[j]) {
                    int temp = numeros[j];
                    numeros[j] = numeros[i];
                    numeros[i] = temp;
                    
                }
            }
        }
        
        // Arrays.stream(numeros).forEach(out::println);
        // printaria o array assim mas muito noob
        
        String numerosComoString = Arrays.stream(numeros).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        out.println("A sequencia do array em ordem crescente fica: " + numerosComoString);
        // optei por uma forma mais pica de printar o array na mesma linha, usando o
        // metodo mapToOb(String::valueOf) que converte os int para String, e tambem
        // usei o .collect(Collectors.joining(" ")), que associa todos os elementos a a
        // uma unica String e as separa com o espaço " "
    }

    // Exercicio 3
    public void calculoJurosCompostos(){
        // funcao simples, recebe os 3 valores, os armazena em floats e int, com suas devidas verificações, apos isso e chamada a funcao de valor final, que vem a fim de realizar a formula de juros compostos

        Scanner leitor = new Scanner(in);
        

        // recebendo o valor inicial
        out.println("Digite o valor inicial do seu investimento");
        while(!leitor.hasNextInt()){
            out.println("por favor, digite um numero inteiro, seu burro");
            leitor.next();
            // da um xingao e faz a verificação se o numero digitado é são int ou string
        }
        float investimentoInicial = leitor.nextInt();

        // recebendo a taxa de juros anual
        out.println("Agora digite a quantos % voce quer de juros anual em seu investimento");
        while(!leitor.hasNextInt()){
            out.println("por favor, digite um numero inteiro, seu troxa");
            leitor.next();
            // da um xingao e faz a verificação se o numero digitado é são int ou string
        }
        float jurosAnal = (leitor.nextFloat() / 100);

        //recebendo a quantidad de anos
        out.println("Quantos anos vc quer manter esse investimento?");
        while(!leitor.hasNextInt()){
            out.println("por favor, digite um numero inteiro, seu vadio");
            leitor.next();
            // da um xingao e faz a verificação se o numero digitado é são int ou string
        }
        int anos = leitor.nextInt();
        
        // fechando leitor
        leitor.close();
        
        // chamando a função com os 3 parametros
        valorFinal(investimentoInicial, jurosAnal, anos);
        
        
    }

    private void valorFinal( float investimentoInicial, float jurosAnal, int anos){
        
        // realizando a formula de juros compostos para obter montante e juros ganhos
        double montante = investimentoInicial * (Math.pow((1 + jurosAnal), anos));
        double jurosGanhos = montante-investimentoInicial;

        System.out.println("Seus juros ganhos são de: R$"+ String.format("%.2f",jurosGanhos)+" e o seu montante é de: R$"+ String.format("%.2f",montante));        
    }

    // Exercicio 4
    public void contaPalavras(){
        // uma função capaz de realizar a contagem de palavras em uma strinfg, a qual recebe a frase, usando de um Do While para realizar verificação se não foi digitado um int no lugar da frase, faz a solicitação novamente caso sim, e no metodo contador, é utilizado um for i que usa o metodo charAt, para ler espaços vazios e aumentar o contador de palavras, que já é iniciado em 1

        Scanner leitor = new Scanner(in);

        // criando a variavel frase
        String frase;
        do{
        out.println("Digite uma frase: ");
        while(leitor.hasNextInt()){
            out.println("digite um frase seu BURRO: ");
            leitor.next();
            // verificando se foi digitado string ou int
        }
        frase = leitor.nextLine();
        } while (frase == null || frase.isEmpty());
        
        out.println(frase);
        leitor.close();
        
        // chamando a braba
        contador(frase);
        
    }

    private void contador(String frase){
        
    int contagemPalavras = 1;
    // declarada a variavel correpondente a quantidade de palavras
    
    for(int i = 0; i < frase.length();i++){
        if(frase.charAt(i) == ' ') contagemPalavras++;
    }
    // um loop que le os espaços das palavras, iniciado em 1, assim quando digitamos "vai toma no cu", ele lê 3 espaços,q ue somado ao primeiro ja declarado, formam 4, que corresponde ao numero de palavras

     out.println("sua frase possui"+contagemPalavras); 
    }

    // Exercicio 5
    public void combinacoes(){


        // meuArray1 e 2
    }



    // Exercicio 6 
    public void calculaDistanciaPontos(){
        Scanner leitor = new Scanner(in);
        // nesta funçao temos uma calculadores que realiza a formula de calculo de distancia entre dois pontos, em que, recebe duas variaveis, Xa e Ya, as armazena e idem para as variaveis Xb e Yb, em seguida é aplicada a formula no metodo calculoAuxiliar, que soma e eleva ao quadrado os X's e Y's, armazena, e joga pra variavel distancia que realiza o calculo da raiz quadrada, que enfim, printa o resultado
        
        // recebendo o primeiro ponto
        out.println("digite o x1");
        int x1 = leitor.nextInt();
        out.println("digite o y1");
        int y1 = leitor.nextInt();

        // recebendo o segundo ponto      
        out.println("digite o x2");
        int x2 = leitor.nextInt();
        out.println("digite o y2");
        int y2 = leitor.nextInt();

        leitor.close();
        calculoAuxiliar(x1, x2, y1, y2);
    }

    public void calculoAuxiliar(int x1, int x2, int y1, int y2){

        // criando as variaveis dos resultados das somas elevadas ao quadrado da formula
        double xs = Math.pow((x2 - x1), 2);
        double ys = Math.pow((y2 - y1), 2);
        
        // criando a variavel com a raiz quadrada
        double distancia = Math.sqrt(xs + ys);
        
        // printando a distancia
        out.println("A distancia entre os dois pontos é de: "+ String.format("%.2f",distancia));
        
        // podia ter feito tudo em apenas uma linha, mas ficaria confuso e feio pacaralho, e como nao estamos economizando linhas ainda mandei mais separado
    }

}
