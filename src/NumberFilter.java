
import java.awt.Toolkit;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.JTextComponent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ok
 */
class NumberFilter extends DocumentFilter {

   private static  String REMOVE_REGEX = "[^0-9/.]";
   
   
   private boolean filter = true;
JTextPane jtp ;
    NumberFilter(JTextComponent ts) {
 jtp = (JTextPane) ts;
    }

   @Override
   public void insertString(FilterBypass fb, int offset, String text,
         AttributeSet attr) throws BadLocationException {

       
         if (filter) {
         
 
        if(jtp.getText().contains(".")){

     REMOVE_REGEX = "[^0-9-]";
 }else{
        REMOVE_REGEX = "[^0-9.-]";
        }
    
   
        
         
          
        text = text.replaceAll(REMOVE_REGEX, "");
      
           if(text.matches(REMOVE_REGEX)
                  )
      {
     
          Toolkit.getDefaultToolkit().beep();
      }
      }
      super.insertString(fb, offset,text, attr);


   }

   @Override
   public void replace(FilterBypass fb, int offset, int length, String text,
         AttributeSet attrs) throws BadLocationException {
       
       if((fb.getDocument().getLength()+text.length())>=16){
      System.out.println("345");
           text="";
       }
 
        if(jtp.getText().contains(".")){

     REMOVE_REGEX = "[^0-9]";
 }else{
        REMOVE_REGEX = "[^0-9.]";
        }
    
        
          
        text = text.replaceAll(REMOVE_REGEX, "");
      
           if(text.matches(REMOVE_REGEX)
                  )
      {
     
          Toolkit.getDefaultToolkit().beep();
      }
      
      super.replace(fb, offset, length, text, attrs);

   }
}
