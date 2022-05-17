/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC;

/**
 *
 * @author Alessio
 */
public class HomeController extends Controller{
    private HomeModel homeModel;
    
    public HomeController(HomeModel hm){
       super(hm);
       homeModel=hm;
   }
    
    public void change(int i){
        switch(i){
            case 0: homeModel.adjValues(true,false,false);
            break;
            case 1: homeModel.adjValues(false,true,false);
            break;
            case 2: homeModel.adjValues(false,false,true);
        }
    }
}
