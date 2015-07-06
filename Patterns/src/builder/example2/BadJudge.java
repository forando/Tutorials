package builder.example2;

/**
 * Created by forando on 05.07.15.<br/>
 * This is <b>Director</b> realisation according to Builder Pattern.
 */
public class BadJudge implements Judge {

    @Override
    public void announceVerdict(VerdictBuilder builder){
        /*
        процесс конструирования обеспечивает различные представления конструируемого объекта.
        Здесь мы поменяли очередность конструирования тех же элементов и получили
        совершенно другое представление объекта (в нашем случае это приговор).
         */
        builder.buildPartB();
        builder.buildPartC();
        builder.buildPartA();
    }
}
