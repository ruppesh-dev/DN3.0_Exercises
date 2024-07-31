package designPatterns.commandExample;

public class CommandPatternTest {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();

        Command turnLightOn = new LightOnCommand(livingRoomLight);
        Command turnLightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();


        remote.setCommand(turnLightOn);
        remote.pressButton();

        
        remote.setCommand(turnLightOff);
        remote.pressButton();
    }
}
