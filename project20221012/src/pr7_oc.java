import java.util.*;
import java.util.Scanner;

class Word_oc {
    private String eng; //영어 단어
    private String kor; //한글 단어
    public Word_oc(String eng, String kor) {
        this.eng = eng;
        this.kor = kor;
    }
    public String getEng() {
        return eng;
    }
    public String getKor() {
        return kor;
    }
}

class Ex {
    int ex[] = {-1, -1, -1, -1}; // 4개의 보기 배열을 -1로 초기화 해 둠.

    public Ex(int num, int size) {
        int answerNum = (int)(Math.random()*4); // 1~4중 정답의 번호
        ex[answerNum] = num; // 정답의 인덱스 번호
        for(int i=0; i<4; i++) {
            int n = (int)(Math.random()*size);
            if(ex[i]==-1) {
                ex[i] = n;
            }
            else continue;

            for(int j=0; j<4; j++) {
                if(i!=j && ex[j]==ex[i]) {
                    ex[i] = -1;
                    i--;
                }
                else continue;
            }
        }
    }
}

public class pr7_oc {
    Scanner scanner = new Scanner(System.in);
    Vector<Word_oc> v = new Vector<Word_oc>();
    private String name;

    public pr7_oc(String name) { // 단어 테스트 이름과 단어 삽입.
        this.name = name;
        v.add(new Word_oc("love", "사랑"));
        v.add(new Word_oc("animal", "동물"));
        v.add(new Word_oc("picture", "그림"));
        v.add(new Word_oc("emotion", "감정"));
        v.add(new Word_oc("baby", "아기"));
        v.add(new Word_oc("error", "오류"));
        v.add(new Word_oc("society", "사회"));
        v.add(new Word_oc("doll", "인형"));
        v.add(new Word_oc("bear", "곰"));
        v.add(new Word_oc("example", "보기"));
        v.add(new Word_oc("deal", "거래"));
        v.add(new Word_oc("photo", "사진"));
        v.add(new Word_oc("human", "인간"));
        v.add(new Word_oc("statue", "조각상"));
        v.add(new Word_oc("eye", "눈"));
        v.add(new Word_oc("hand", "손"));
        v.add(new Word_oc("ant", "개미"));
    }

    public void Run() {
        System.out.println("\"" + name + "\"" + "의 단어 태스트를 시작합니다. -1을 입력하면 종료합니다.");
        System.out.println("현재 " + v.size() + "의 단어가 들어있습니다.");
        Quiz();
    }

    public void Quiz() {
        while(true) {
            int num = (int)(Math.random()*v.size());
            String e = v.get(num).getEng();
            System.out.println(e + "?");

            Ex example = new Ex(num, v.size());
            for(int i=0; i<4; i++) {
                System.out.print("(" + (i+1) + ")" + v.get(example.ex[i]).getKor() + " ");
            }
            int sel = scanner.nextInt();
            if(sel == -1) {
                System.out.println("\"" + name + "\"" + "을 종료합니다");
                return;
            }
            else if(example.ex[(sel-1)] == num)
                System.out.println("Excellent !!");
            else
                System.out.println("No. !!");
        }
    }

    public static void main(String[] args) {
        pr7_oc wq = new pr7_oc("명품영어");
        wq.Run();
    }
}


