import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class SessionController {
    @FXML
    private BorderPane mainWordPane;

    @FXML
    private Label noSolutionLabel;

    @FXML
    private TextField hcIterations;

    @FXML
    private TextField queens;

    @FXML
    private SplitPane splitWordList;

    @FXML
    private TextField gaGenerations;

    @FXML
    private TextField gaInitialPopulationSize;

    @FXML
    private TextField gaMutationProbability;

    GUIPuzzle guiPuzzle = new GUIPuzzle();

    private int getNum(TextField tf) {
        return Integer.parseInt(tf.getText());
    }

    private double getDouble(TextField tf) {
        return Double.parseDouble(tf.getText());
    }

    @FXML
    void runHillClimbing() {
        HillClimbing hillClimbing = new HillClimbing();
        int[] res = hillClimbing.solve(getNum(queens), getNum(hcIterations));

        showResult(res);
    }


    private void showResult(int[] res) {
        guiPuzzle.drawQueens(res);
        noSolutionLabel.setVisible(res == null);
    }


    @FXML
    void runGeneticAlgorithm() {

        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm();
        int[] res = geneticAlgorithm.solve(getNum(queens), getNum(gaInitialPopulationSize), getDouble(gaMutationProbability), getNum(gaGenerations));

        showResult(res);
    }

    @FXML
    void initialize() {
        assert mainWordPane != null : "fx:id=\"mainWordPane\" was not injected: check your FXML file 'session.fxml'.";
        assert hcIterations != null : "fx:id=\"hcIterations\" was not injected: check your FXML file 'session.fxml'.";
        assert queens != null : "fx:id=\"queens\" was not injected: check your FXML file 'session.fxml'.";
        assert splitWordList != null : "fx:id=\"splitWordList\" was not injected: check your FXML file 'session.fxml'.";
        assert gaGenerations != null : "fx:id=\"gaGenerations\" was not injected: check your FXML file 'session.fxml'.";
        assert gaMutationProbability != null : "fx:id=\"gaMutationProbability\" was not injected: check your FXML file 'session.fxml'.";


        mainWordPane.setCenter(guiPuzzle);
        mainWordPane.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, CornerRadii.EMPTY, new Insets(0, 0, 0, 0))));

    }
}
