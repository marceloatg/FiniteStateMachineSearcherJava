package engine;

/**
 * @author      Marcelo A. T. Gomes
 */
public class FiniteStateMachine {
    
    String transitions;
    int transitionsNumber;
    int state;
    int statesNumber;
    int validity;
    
    public FiniteStateMachine(String target) {
        
        transitionsNumber = target.length();
        statesNumber = transitionsNumber;
        transitions = target;
        state = 0;
        validity = 0;
    }
    
    public int run(String word){
        
        for(int aux = 0; aux < word.length(); aux++)
        {
            setState(word.charAt(aux));
        }
        
        return getValidade();
    }
    
    private void setState(char transicao) {
        
        // Reset
        if (state == statesNumber) 
        {
            validity++;
            state = 0;
        }
        
        // Set
        if (transicao == transitions.charAt(state)) state++;
        else state = 0;
    }
    
    int getValidade () {
        
        return validity;
    }
}
