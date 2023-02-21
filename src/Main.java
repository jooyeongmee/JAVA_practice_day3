//6-1. 다음과 같은 멤버 변수를 갖는 Student 클래스를 정의하세요.
//타입 : String, 변수명 : name, 설명 : 학생 이름
//타입 : int, 변수명 : ban, 설명 : 반
//타입 : int, 변수명 : no, 설명 : 번호
//타입 : int, 변수명 : kor, 설명 : 국어 점수
//타입 : int, 변수명 : eng, 설명 : 영어 점수
//타입 : int, 변수명 : math, 설명 : 수학 점수

class Student{
    /*빈 칸*/
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;
    public Student() {}

    public Student(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    String info() {
        String info = "" + this.name;
        info += ", " + this.ban;
        info += ", " + this.no;
        info += ", " + this.kor;
        info += ", " + this.eng;
        info += ", " + this.math;
        info += ", " + getTotal();
        info += ", " + getAverage();


        return info;
    }
    int getTotal() {
        return this.kor + this.eng + this.math;
    }
    float getAverage() {
        int total_score = getTotal();
        float average = Math.round((total_score / 3f)*10)/10f;
        return average;
    }
}

//6-2. 6-1에서 정의한 Student 클래스에 생성자와 info()를 추가해서 실행결과와 같은 결과를 얻도록 하세요.
class Exercise6_2{
    public static void main(String[] args){
        Student s = new Student("홍길동", 1, 1, 100, 60, 76);

        String str = s.info();
        System.out.println(str);
    }// 예상 결과 : 홍길동, 1, 1, 100, 60, 76, 236, 78.7
}



//6-3. 연습문제 6-1에서 정의한 Student 클래스에 다음과 같이 정의된 두 개의 메서드를 추가하세요.
//1. 메서드명 : getTotal
//기능 : 국어(kor), 영어(eng), 수학(math)의 점수를 모두 더해서 반환한다.
//반환타입 : int
//매개변수 : 없음
//2. 메서드명 : getAverage
//기능 : 총점(국어점수+영어점수+수학점수)을 과목수로 나눈 평균을 구한다.
//소수점 둘째자리에서 반올림할 것.
//반환타입 : float
//매개변수 : 없음

class Exercise6_3 {
    public static void main(String args[]) {
        Student s = new Student();
        s.name = "홍길동";
        s.ban = 1;
        s.no = 1;
        s.kor = 100;
        s.eng = 60;
        s.math = 76;
        System.out.println("이름 :"+s.name);
        System.out.println("총점 :"+s.getTotal());
        System.out.println("평균 :"+s.getAverage());
    }//예상 결과 : 이름 : 홍길동, 총점 : 236, 평균 : 78.7
}




//6-5. 다음의 코드에 정의된 변수들을 종류별(클래스 변수,인스턴스 변수, 지역변수)로 구분해서 적으세요.
class PlayingCard {
    int kind; //인스턴스 변수
    int num; //인스턴스 변수
    static int width; //클래스 변수
    static int height; //클래스 변수
    PlayingCard(int k, int n) {
        kind = k; //k, n: 지역변수. kind,num: 인스턴스 변수
        num = n;
    }
    public static void main(String args[]) {
        PlayingCard card = new PlayingCard(1,1);
    }
}


//6-7. 다음은 컴퓨터 게임의 병사(marine)를 클래스로 정의한 것이다.
//이 클래스의 멤버 중에 static을 붙여야 하는 것은 어떤 것들이고 그 이유는 무엇인가?
//(단, 모든 병사의 공격력과 방어력은 같아야 한다.)
class Marine {
    int x=0, y=0; //Marine의 위치좌표 (x,y)
    int hp = 60; //현재 체력
    int weapon = 6; //공격력  //---> static 붙여야 함. 왜냐하면 모든 병사가 똑같이 갖고 있어야 하는 속성이기 때문
    int armor = 0; //방어력   //---> static 붙여야 함
    void weaponUp() { //---> static 붙여야 함 왜냐하면 모든 병사가 똑같이 갖고 있어야 하는 메서드(기능)이기 때문
        weapon++;
    }
    void armorUp() {  //---> static 붙여야 함
        armor++;
    }
    void move(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

//6-16. 다음 코드의 실행 결과를 예측하여 적어주세요.
class Exercise6_16 {
    public static void change(String str) {
        str += "456";
    }

    public static void main(String[] args) {
        String str = "ABC123";
        System.out.println(str);
        change(str);
        System.out.println("After change:" + str);
    }
}


class Exercise6_17 {

    /*shuffle 메서드를 작성하세요. */
    static int[] shuffle(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[0];
            int idx = (int)(Math.random()*arr.length);
            arr[0] = arr[idx];
            arr[idx] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] original = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        System.out.println(java.util.Arrays.toString(original));

        int[] result = shuffle(original);
        System.out.println(java.util.Arrays.toString(result));
    }
}

class Exercise6_18 {

    /*isNumber 메서드를 작성하세요.*/
    static boolean isNumber(String str) {
        boolean result = true;
        if (str == null || str.length() == 0) return false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c)) {
                result = false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "123";
        System.out.println(str + " 는 숫자입니까? " + isNumber(str));
        str = "1234o";
        System.out.println(str + " 는 숫자입니까? " + isNumber(str));
    }
}
//예상 결과 : 123는 숫자입니까? true, 1234o는 숫자입니까? false


class MyTv {
    boolean isPowerOn;
    int channel;
    int volume;
    final int MAX_VOLUME = 100;
    final int MIN_VOLUME = 0;
    final int MAX_CHANNEL = 100;
    final int MIN_CHANNEL = 1;
    void turnOnOff() {
        // (1) isPowerOn의 값이 true면 false로, false면 true로 바꾼다.
        if (isPowerOn) isPowerOn = false;
        else isPowerOn = true;
    }
    void volumeUp() {
        // (2) volume의 값이 MAX_VOLUME보다 작을 때만 값을 1 증가시킨다.
        if (volume < MAX_VOLUME) volume++;
    }
    void volumeDown() {
        // (3) volume의 값이 MIN_VOLUME보다 클 때만 값을 1 감소시킨다.
        if (volume > MIN_VOLUME) volume--;
    }
    void channelUp() {
        // (4) channel의 값을 1 증가시킨다.
        // 만일 channel이 MAX_CHANNEL이면 , channel의 값을 MIN_CHANNEL로 바꾼다.
        channel++;
        if (channel > MAX_CHANNEL) channel = MIN_CHANNEL;
    }
    void channelDown() {
        // (5) channel의 값을 1 감소시킨다 .
        // 만일 channel이 MIN_CHANNEL이면, channel의 값을 MAX_CHANNEL로 바꾼다.
        channel--;
        if (channel < MIN_CHANNEL) channel = MAX_CHANNEL;
    }
}

class Exercise6_19 {
    public static void main(String args[]) {
        MyTv t = new MyTv();
        t.channel = 100;
        t.volume = 0;
        System.out.println("CH:" + t.channel + ", VOL:" + t.volume);
        t.channelDown();
        t.volumeDown();
        System.out.println("CH:" + t.channel + ", VOL:" + t.volume);
        t.volume = 100;
        t.channelUp();
        t.volumeUp();
        System.out.println("CH:" + t.channel + ", VOL:" + t.volume);
    }
}

//예상 결과 : CH: 100, VOL: 0 / CH: 99, VOL: 0 / CH: 100, VOL: 100

class Exercise6_20 {
    /* (1) max 메서드를 작성하시오 . */
    static int max(int[] arr) {
        int max = 0;
        if (arr == null || arr.length == 0) return -999999;
        for (int a : arr) {
            if (a > max) max = a;
        }
        return max;
    }
    public static void main(String[] args) {
        int[] data = {3,2,9,4,7};
        System.out.println(java.util.Arrays.toString(data));
        System.out.println("최대값 :"+max(data));
        System.out.println("최대값 :"+max(null));
        System.out.println("최대값  :"+max(new int[]{})); // 크기가 0인 배열  }
    }
}

//예상 결과 : 최대값: 9 / 최대값: -99999 최대값: -999999

class Exercise6_21 {
    /* (1) abs 메서드를 작성하시오. */
    static int abs(int value) {
        return Math.abs(value);
    }
    public static void main(String[] args) {
        int value = 5;
        System.out.println(value + "의 절대값 :" + abs(value));
        value = -10;
        System.out.println(value + "의 절대값 :" + abs(value));
    }
}
//예상 결과 : 5의 절대값 : 5 / -10의 절대값 : 10
