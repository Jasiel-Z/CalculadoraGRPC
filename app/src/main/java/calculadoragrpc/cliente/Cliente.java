package calculadoragrpc.cliente;

import javax.swing.JOptionPane;

import com.proto.calculadora.Calculadora.OperacionRequest;
import com.proto.calculadora.Calculadora.OperacionResponse;
import com.proto.calculadora.CalculadoraServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Cliente {
    public static void main(String[] args) {
        String host  = "localhost";
        int puerto = 9001;

        ManagedChannel ch = ManagedChannelBuilder.forAddress(host, puerto).
        usePlaintext().build();

        CalculadoraServiceGrpc.CalculadoraServiceBlockingStub stub = CalculadoraServiceGrpc.newBlockingStub(ch);
        
        while(true){
            String option = JOptionPane.showInputDialog(
                "Calcular\n" +
                "Suma............ (1)\n" +
                "Resta........... (2)\n" +
                "Multiplicacion.. (3)\n" +
                "Division........ (4)\n\n" +
                "Cancelar para salir"
            );

            if (option == null){
                break;
            }

            double a = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el primer operando"));
            double b = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el segundo operando"));
            double result = 0;

            OperacionRequest request = OperacionRequest.newBuilder().setOperando1(a).setOperando2(b).build();

            

            switch (option) {
                case "1":
                OperacionResponse response = stub.sumar(request);
                result = response.getResultado();
                    break;
            
                case "2":
                OperacionResponse response2 = stub.restar(request);
                result = response2.getResultado();
                    break;
                case "3":
                OperacionResponse response3 = stub.multiplicar(request);
                result = response3.getResultado();
                    break;
                case "4": 
                OperacionResponse response4 = stub.dividir(request);
                result = response4.getResultado();
                    break;     

            }
            JOptionPane.showMessageDialog(null, "Resultado: " + result);


        }
        ch.shutdown();
    }   
}
