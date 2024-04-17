package calculadoragrpc.servidor;

import com.proto.calculadora.Calculadora.OperacionRequest;
import com.proto.calculadora.Calculadora.OperacionResponse;
import com.proto.calculadora.CalculadoraServiceGrpc;

import io.grpc.stub.StreamObserver;


public class ServidorImp extends CalculadoraServiceGrpc.CalculadoraServiceImplBase{
    @Override
    public void sumar(OperacionRequest request, StreamObserver<OperacionResponse> responObserver){
        double resultado = request.getOperando1() + request.getOperando2();
        OperacionResponse respuesta =  OperacionResponse.newBuilder().setResultado(resultado).build();
        responObserver.onNext(respuesta);
        responObserver.onCompleted();
    }   


    @Override
    public void restar(OperacionRequest request, StreamObserver<OperacionResponse> responObserver){
        double resultado = request.getOperando1() - request.getOperando2();
        OperacionResponse respuesta =  OperacionResponse.newBuilder().setResultado(resultado).build();
        responObserver.onNext(respuesta);
        responObserver.onCompleted();
    }

    @Override
    public void multiplicar(OperacionRequest request, StreamObserver<OperacionResponse> responObserver){
        double resultado = request.getOperando1() * request.getOperando2();
        OperacionResponse respuesta =  OperacionResponse.newBuilder().setResultado(resultado).build();
        responObserver.onNext(respuesta);
        responObserver.onCompleted();
    }


    public void dividir(OperacionRequest request, StreamObserver<OperacionResponse> responObserver){
        double resultado = request.getOperando1() / request.getOperando2();
        OperacionResponse respuesta =  OperacionResponse.newBuilder().setResultado(resultado).build();
        responObserver.onNext(respuesta);
        responObserver.onCompleted();
    }
}
