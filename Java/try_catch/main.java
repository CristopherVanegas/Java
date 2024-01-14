class mainClass {
    public static void main(String args[]) {
        System.out.println("Hola mundo!"); 

        try { 
            try {
                throw new Error('oops'); 
            } 
    
            catch {
                console.error('inner', ex.message);
                throw ex; 
            } 
    
            finally {
                console.log('finally'); 
            }
        } 

        catch(ex) {
            console.error('outer', ex.message); 
        }
    }

}


// source: 
// --> https://developer.mozilla.org/es/docs/Web/JavaScript/Reference/Statements/try...catch 


