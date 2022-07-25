# jivo-lib
I worked with Java API a lot, so i thought about my first library.


## How to use

Create new EventManager

```java
EventManager eventManager = new EventManager();
```
Make your impllementation of EventListener(for example EventListenerImpl):
```java
public class EventListenerImpl implements EventListener{
    @Override
    public void updateReceived(Update update) {
        ClientMessage clientMessage = update.getClientMessage();
        JivoService jivoService = update.getJivoService();

        Message message = clientMessage.getMessage();
        String text = message.getText();

        Message newMessage = new MessageText();
        newMessage.setText(text);

        BotMessage botMessage = new BotMessage(clientMessage.getClient_id(), clientMessage.getChat_id(), newMessage);

        try{
            jivoService.sendBotMessage(botMessage);
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
```
Add your listener to EvenManager

```java
eventManager.addListener(new EventListenerImpl());
```
Create new JivoBotApplication

```java
JivoBotApplication jivoBotApplication = new JivoBotApplication(eventManager,8080,"token");
```

