# jivo-lib

### Add to your project
See releases

### How to use
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

Add your listener to EventManager
```java
eventManager.addListener(new EventListenerImpl());
```

Create new JivoBotApplication
```java
JivoBotApplication jivoBotApplication = new JivoBotApplication(eventManager,8080,"provider_id/your_token");
```

### How i can get my token?
1. Сome up with your own unique token for the bot
2. Go to [JivoWebSite](https://www.jivo.ru/) and register 
3. Go to [Jivo Bot Api page](https://www.jivo.ru/help/api/bot-api.html)
4. Write to [Jivo](info@jivosite.com) that you are creating your bot ,and you need provider id.
5. Follow instructions.
6. If you have any questions, ask them in the chat on Jivo website.
7. At the end, you have provider id and your bot token. Enter "*your_provider_id*/*your_bot_token*" in JivoBotApplication constructor.