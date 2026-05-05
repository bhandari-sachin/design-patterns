import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        ChatRoomMediator mediator = new ChatRoomMediator();

        List<String> users = List.of("Alice", "Bob", "Charlie");

        for (String user : users) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("chat.fxml"));
            Scene scene = new Scene(loader.load());

            ChatClientController controller = loader.getController();
            controller.init(user, mediator, users);

            Stage clientStage = new Stage();
            clientStage.setTitle(user);
            clientStage.setScene(scene);
            clientStage.show();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}