package analyzer;

import entities.*;
import spoon.Launcher;

/**
 * Created by sarra on 17/02/17.
 */
public class Main {


    public static void main(String[] args) {

//        List<CtType<?>> list = launcher.getFactory().Class().getAll();
//        for(CtType ctType: list){
//            System.out.println(ctType.getSimpleName());
//        }
        String path ="../android/src/com/owncloud/android";
        String name = "owncloud";
        String key ="owncloud";
        MainProcessor mainProcessor=new MainProcessor(name,key,path);
        mainProcessor.process();
        showModel(MainProcessor.currentApp);


    }

    public static void showModel(PaprikaApp app){
        System.out.println("App: "+ app.getName());
        for(PaprikaClass paprikaClass: app.getPaprikaClasses()) {
            System.out.println(" Class : "+ paprikaClass.getName());
            System.out.println(" Visibility : "+ paprikaClass.getModifier().name());
            System.out.println(" isActivity : "+paprikaClass.isActivity());
            System.out.println(" isInterface : "+paprikaClass.isInterface());
            System.out.println(" isStatic : "+paprikaClass.isStatic());
            for (PaprikaMethod paprikaMethod: paprikaClass.getPaprikaMethods()) {
                showMethod(paprikaMethod);
            }
            for (PaprikaVariable paprikaVariable: paprikaClass.getPaprikaVariables()){
                showVariable(paprikaVariable);
            }
        }
    }

    public static void showMethod(PaprikaMethod paprikaMethod){
        System.out.println(" Method : "+paprikaMethod.getName());
        System.out.println(" Return type : "+ paprikaMethod.getReturnType());
        System.out.println(" modifier : "+ paprikaMethod.getModifier().name());
        for (PaprikaArgument paprikaArgument: paprikaMethod.getArguments()){
            showArgument(paprikaArgument);
        }
    }

    public  static  void showArgument(PaprikaArgument paprikaArgument){
        System.out.println(" Argument : "+ paprikaArgument.getName());
        System.out.println(" position : "+ paprikaArgument.getPosition());
    }

    public static void showVariable(PaprikaVariable paprikaVariable){
        System.out.println(" Variable : "+paprikaVariable.getName());
        System.out.println(" Type : "+paprikaVariable.getType());
        System.out.println(" Visbility : "+paprikaVariable.getModifier().name());
    }






}
