public class FactoryX {
    public X create(Object obj){
        return new XProxy(obj,new XService());
    }
}
