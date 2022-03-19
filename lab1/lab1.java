package com.company;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class lab1 {
    public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    String text ="В то время как у Ростовых танцевали в зале шестой англез под звуки от усталости" +
" фальшививших музыкантов и усталые официанты и повара готовили ужин, с графом Безуховым" +
" сделался шестой уже удар. Доктора объявили, что надежды к выздоровлению нет;больному " +
"дана была глухая исповедь и причастие; делали приготовления для соборования, и в доме " +
"была суетня и тревога ожидания,обыкновенные в такие минуты. Вне дома, за воротами, " +
"толпились, скрываясь от подъезжающих экипажей, гробовщики, ожидая богатого заказа на " +
"похороны графа.Главнокомандующий Москвы, который беспрестанно присылал адъютантов узнавать" +
" о положении графа, в этот вечер сам приезжал проститься с знаменитым екатерининским вельможей, графом Безуховым." +
"Великолепная приемная комната была полна. Все почтительно встали, когда главнокомандующий, пробыв " +
"около получаса наедине с больным, вышел оттуда, слегка отвечая на поклоны и стараясь как можно скорее " +
"пройти мимо устремленных на него взглядов докторов, духовных лиц и родственников. Князь Василий, " +
"похудевший и побледневший за эти дни, провожал главнокомандующего и что-то несколько раз тихо повторил ему..";
    int shift = 3;
    String ciphertext = "";
    char alphabet;
    for(int i=0; i < text.length();i++)
    {
        alphabet = text.charAt(i);
        if(alphabet >= 'а' && alphabet <= 'я')
    {
    alphabet = (char) (alphabet + shift);
    if(alphabet > 'я') {
    alphabet = (char) (alphabet+'а'-'я'-1);
    }
    ciphertext = ciphertext + alphabet;
    }
        else if(alphabet >= 'А' && alphabet <= 'Я') {
        alphabet = (char) (alphabet + shift);
        if(alphabet > 'Я') {
            alphabet = (char) (alphabet+'А'-'Я'-1);
            }
    ciphertext = ciphertext + alphabet;
    }
    else {
        ciphertext = ciphertext + alphabet;
        }   

     }
    System.out.println(" ciphertext : " + ciphertext);
    String decryptText = decrypt(ciphertext, 3);
    System.out.println(ciphertext);
    System.out.println(decryptText);
    }
public static String decrypt(String text, int key) {
    StringBuilder encryptText = new StringBuilder();
    for (char c : text.toCharArray()) {
    char encryptChar;
    if (c != ' ') {
        encryptChar = (char) (c - key %33);
    } else {
        encryptChar = c;
    }
    encryptText.append(encryptChar);
    }
    return encryptText.toString();
}
public static int methodFrequencyAnalysis(String sourceText, String encryptText) {
    char sourceMaxChar = sourceText.chars().mapToObj(c -> (char) c).filter(c -> c != ' ')
.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).get();
    char encryptMaxChar = encryptText.chars().mapToObj(c -> (char) c).filter((c -> c != ' '))
.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).get();
    return Math.abs(sourceMaxChar - encryptMaxChar);
}
}
package com.company;

class lab2{

public static void main(String[] args)
{
    long P, G, x, a, y, b, kaa, kbb;
    P = 27;
    System.out.println("Значение P:" + P);
    G = 19;
    System.out.println("Значение G:" + G);
    a = 7;
    System.out.println("Приватный ключ Алисы:" + a);
    x = DiffieHellmanpower(G, a, P);
    b = 8;
    System.out.println("Приватный ключ Боба:" + b);
    y = DiffieHellmanpower(G, b, P);
    ka = DiffieHellmanpower(y, a, P);
    kb = DiffieHellmanpower(x, b, P);
    System.out.println("Секретннный ключ Алисы:" + ka);
    System.out.println("Секретный ключ Боба:" + kb);
    }
private static long DiffieHellmanpower(long a, long b, long p)
{
    if (b == 1)
    return a;
    else
    return (((long)Math.pow(a, b)) % p);
}
}
