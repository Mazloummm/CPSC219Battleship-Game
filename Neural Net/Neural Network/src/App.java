import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class App {

    public static void main(String[] args) {
        List<List<Integer>> data = new ArrayList<List<Integer>>();
        data.add(Arrays.asList(115, 66));
        data.add(Arrays.asList(175, 78));
        data.add(Arrays.asList(205, 72));
        data.add(Arrays.asList(120, 67));
        List<Double> answers = Arrays.asList(1.0, 0.0, 0.0, 1.0);

        App app = new App();
        Network network = app.new Network();
        network.train(data, answers);
    }

    class Neuron {
        Random rand = new Random();
        private Double Bias = rand.nextDouble(-1,1); // Bias
        public Double weight1 = rand.nextDouble(-1,1); // Weight 1
        private Double weight2 = rand.nextDouble(-1,1); // Weight 2

        public double compute(double input1, double input2) {
            double preActivation = (this.weight1 * input1) + (this.weight2 * input2) + this.Bias;
            double output = Util.sigmoid(preActivation);
            return output;
        }
    }

    public class Util {
        public static double sigmoid(double x) {
            return 1 / (1 + Math.exp(-x));
        }
    }

    class Network {
        List<Neuron> neurons = Arrays.asList(
            new Neuron(), new Neuron(), new Neuron(),
            new Neuron(), new Neuron(),  
            new Neuron());
    }

    public Double predict(Integer input1, Integer input2) {
        return neurons.get(5).compute(
            neurons.get(4).compute(
                neurons.get(0).compute(input1, input2),
                neurons.get(1).compute(input1, input2)
            ),
            neurons.get(3).compute(
                neurons.get(2).compute(input1, input2),
                neurons.get(1).compute(input1, input2)
            )
        );
    }

    public static Double meanSquareLoss(List<Double> correctAnswers,   List<Double> predictedAnswers){
        double sumSquare = 0;
        for (int i = 0; i < correctAnswers.size(); i++){
          double error = correctAnswers.get(i) - predictedAnswers.get(i);
          sumSquare += (error * error);
        }
        return sumSquare / (correctAnswers.size());
    }
    
    public void neurons() {
        Random rand = new Random();
        private Double oldBias = rand.nextDouble(-1, 1), bias = rand.nextDouble(-1, 1); 
        public Double oldWeight1 = rand.nextDouble(-1, 1), weight1 = rand.nextDouble(-1, 1); 
        private Double oldWeight2 = rand.nextDouble(-1, 1), weight2 = rand.nextDouble(-1, 1);
        public void mutate(){ // Mutate() method pcisk a property at rand an
                int propertyToChange = rand.nextInt(0, 3);
                Double changeFactor = rand.nextDouble(-1, 1);
                if (propertyToChange == 0){ 
                this.bias += changeFactor; 
                } else if (propertyToChange == 1){ 
                this.weight1 += changeFactor; 
                } else { 
                this.weight2 += changeFactor; 
                };
            }
            public void forget(){
                bias = oldBias;
                weight1 = oldWeight1;
                weight2 = oldWeight2;
            }
            public void remember(){
                oldBias = bias;
                oldWeight1 = weight1;
                oldWeight2 = weight2;
            }
        }
    }
  
    public void train(List<List<Integer>> data, List<Double> answers){
        Double bestEpochLoss = null;
        for (int epoch = 0; epoch < 1000; epoch++){
        // adapt neuron
        Neuron epochNeuron = neurons.get(epoch % 6);
        epochNeuron.mutate(this.learnFactor);
    
        List<Double> predictions = new ArrayList<Double>();
        for (int i = 0; i < data.size(); i++){
            predictions.add(i, this.predict(data.get(i).get(0), data.get(i).get(1)));
        }
        if (bestEpochLoss == null){
            bestEpochLoss = thisEpochLoss;
            epochNeuron.remember();
            } else {
        if (thisEpochLoss < bestEpochLoss){
            bestEpochLoss = thisEpochLoss;
            epochNeuron.remember();
        } else {
            epochNeuron.forget();
        }
        }
        }
      
}
    
