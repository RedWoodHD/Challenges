package MiniGames.Hangman;

public class PictureOfHangman
{
    private static void printLittleMan()
    {
        System.out.println("""
                              xxxxxxxxxxxxxxxxxxxxxxxxx       \s
                              x      xxx              x       \s
                             xx    xxx                x       \s
                             x   xx                   x       \s
                            xx xx                     x       \s
                            xxx                       x       \s
                            x                         x       \s
                            x                       xxxxx     \s
                            x                      xx    x    \s
                           xx                      x x x x    \s
                           x                       x     x    \s
                           x                       xx    x    \s
                           x                        xxxxx     \s
                           x                          x       \s
                           x                          x       \s
                           x                   xxx x  x  xx xxx
                          x                           x       \s
                          x                           x       \s
                          x                           x       \s
                         xx                           x       \s
                         xx                          xxx      \s
                     xxxxxxxxxx                     xx xx     \s
                  xxxx        xxxx                 xx   xx    \s
                 xx              xx               xx     xx   \s
                xx                xx              x       x   \s
                x                  x                          \s
                """);
    }
    public static void printStage(int stageNumber)
    {
        switch (stageNumber)
        {
            case 1:
                System.out.println("""
                                 
                             xxxxxxxxxx
                          xxxx        xxxx
                         xx              xx
                        xx                xx
                        x                  x
                        """);
                break;
            case 2:
                System.out.println("""
                                      x
                                      x
                                     xx
                                     x
                                    xx
                                    xx
                                    x
                                    x
                                    x
                                   xx
                                   x
                                   x
                                   x
                                   x
                                   x
                                   x
                                  x
                                  x
                                  x
                                 xx
                                 xx
                             xxxxxxxxxx
                          xxxx        xxxx
                         xx              xx
                        xx                xx
                        x                  x
                        """);
                break;
            case 3:
                System.out.println("""
                                      xxxxxxxxxxxxxxxxxxxxxxxxx
                                      x     
                                     xx    
                                     x   
                                    xx 
                                    xx
                                    x
                                    x
                                    x
                                   x
                                   x
                                   x
                                   x
                                   x
                                   x
                                   x
                                  x
                                  x
                                  x
                                 xx
                                 xx
                             xxxxxxxxxx
                          xxxx        xxxx
                         xx              xx
                        xx                xx
                        x                  x
                        """);
                break;
            case 4:
                System.out.println("""
                                      xxxxxxxxxxxxxxxxxxxxxxxxx     
                                      x      xxx       
                                     xx    xxx       
                                     x   xx       
                                    xx xx       
                                    xxx       
                                    x       
                                    x                  
                                    x                   
                                   xx                  
                                   x                     
                                   x                    
                                   x                   
                                   x       
                                   x       
                                   x                     
                                  x       
                                  x       
                                  x       
                                 xx       
                                 xx                    
                             xxxxxxxxxx                
                          xxxx        xxxx              
                         xx              xx              
                        xx                xx              
                        x                  x       
                        """);
                break;
            case 5:
                System.out.println("""
                                      xxxxxxxxxxxxxxxxxxxxxxxxx       \s
                                      x      xxx              x       \s
                                     xx    xxx                x       \s
                                     x   xx                   x       \s
                                    xx xx                     x       \s
                                    xxx                       x       \s
                                    x                         x       \s
                                    x         
                                    x         
                                   xx         
                                   x          
                                   x          
                                   x          
                                   x          
                                   x          
                                   x          
                                  x           
                                  x           
                                  x           
                                 xx           
                                 xx           
                             xxxxxxxxxx       
                          xxxx        xxxx    
                         xx              xx   
                        xx                xx  
                        x                  x  
                        """);
                break;
            case 6:
                System.out.println("""
                                      xxxxxxxxxxxxxxxxxxxxxxxxx       \s
                                      x      xxx              x       \s
                                     xx    xxx                x       \s
                                     x   xx                   x       \s
                                    xx xx                     x       \s
                                    xxx                       x       \s
                                    x                         x       \s
                                    x                       xxxxx     \s
                                    x                      xx    x    \s
                                   xx                      x x x x    \s
                                   x                       x     x    \s
                                   x                       xx    x    \s
                                   x                        xxxxx     \s
                                   x             
                                   x             
                                   x             
                                  x              
                                  x              
                                  x              
                                 xx              
                                 xx              
                             xxxxxxxxxx          
                          xxxx        xxxx       
                         xx              xx      
                        xx                xx     
                        x                  x     
                        """);
                break;
            case 7:
                System.out.println("""
                                      xxxxxxxxxxxxxxxxxxxxxxxxx       \s
                                      x      xxx              x       \s
                                     xx    xxx                x       \s
                                     x   xx                   x       \s
                                    xx xx                     x       \s
                                    xxx                       x       \s
                                    x                         x       \s
                                    x                       xxxxx     \s
                                    x                      xx    x    \s
                                   xx                      x x x x    \s
                                   x                       x     x    \s
                                   x                       xx    x    \s
                                   x                        xxxxx     \s
                                   x                          x       \s
                                   x                          x       \s
                                   x                          x       \s
                                  x                           x       \s
                                  x                           x       \s
                                  x                           x       \s
                                 xx                           x       \s
                                 xx                           x
                             xxxxxxxxxx                     
                          xxxx        xxxx                 
                         xx              xx               
                        xx                xx              
                        x                  x              
                        """);
                break;
            case 8:
                System.out.println("""
                                      xxxxxxxxxxxxxxxxxxxxxxxxx       \s
                                      x      xxx              x       \s
                                     xx    xxx                x       \s
                                     x   xx                   x       \s
                                    xx xx                     x       \s
                                    xxx                       x       \s
                                    x                         x       \s
                                    x                       xxxxx     \s
                                    x                      xx    x    \s
                                   xx                      x x x x    \s
                                   x                       x     x    \s
                                   x                       xx    x    \s
                                   x                        xxxxx     \s
                                   x                          x       \s
                                   x                          x       \s
                                   x                   xxx x  x
                                  x                           x       \s
                                  x                           x       \s
                                  x                           x       \s
                                 xx                           x       \s
                                 xx
                             xxxxxxxxxx
                          xxxx        xxxx
                         xx              xx
                        xx                xx
                        x                  x
                        """);
                break;
            case 9:
                System.out.println("""
                                      xxxxxxxxxxxxxxxxxxxxxxxxx       \s
                                      x      xxx              x       \s
                                     xx    xxx                x       \s
                                     x   xx                   x       \s
                                    xx xx                     x       \s
                                    xxx                       x       \s
                                    x                         x       \s
                                    x                       xxxxx     \s
                                    x                      xx    x    \s
                                   xx                      x x x x    \s
                                   x                       x     x    \s
                                   x                       xx    x    \s
                                   x                        xxxxx     \s
                                   x                          x       \s
                                   x                          x       \s
                                   x                   xxx x  x  xx xxx
                                  x                           x       \s
                                  x                           x       \s
                                  x                           x       \s
                                 xx                           x       \s
                                 xx                          
                             xxxxxxxxxx                     
                          xxxx        xxxx                 
                         xx              xx               
                        xx                xx             
                        x                  x             
                        """);
                break;
            case 10:
                System.out.println("""
                                      xxxxxxxxxxxxxxxxxxxxxxxxx       \s
                                      x      xxx              x       \s
                                     xx    xxx                x       \s
                                     x   xx                   x       \s
                                    xx xx                     x       \s
                                    xxx                       x       \s
                                    x                         x       \s
                                    x                       xxxxx     \s
                                    x                      xx    x    \s
                                   xx                      x x x x    \s
                                   x                       x     x    \s
                                   x                       xx    x    \s
                                   x                        xxxxx     \s
                                   x                          x       \s
                                   x                          x       \s
                                   x                   xxx x  x  xx xxx
                                  x                           x       \s
                                  x                           x       \s
                                  x                           x       \s
                                 xx                           x       \s
                                 xx                          xx
                             xxxxxxxxxx                     xx 
                          xxxx        xxxx                 xx  
                         xx              xx               xx   
                        xx                xx              x    
                        x                  x                    
                        """);
                break;
            case 11:
                System.out.println("""
                                      xxxxxxxxxxxxxxxxxxxxxxxxx       \s
                                      x      xxx              x       \s
                                     xx    xxx                x       \s
                                     x   xx                   x       \s
                                    xx xx                     x       \s
                                    xxx                       x       \s
                                    x                         x       \s
                                    x                       xxxxx     \s
                                    x                      xx    x    \s
                                   xx                      x x x x    \s
                                   x                       x     x    \s
                                   x                       xx    x    \s
                                   x                        xxxxx     \s
                                   x                          x       \s
                                   x                          x       \s
                                   x                   xxx x  x  xx xxx
                                  x                           x       \s
                                  x                           x       \s
                                  x                           x       \s
                                 xx                           x       \s
                                 xx                          xxx      \s
                             xxxxxxxxxx                     xx xx     \s
                          xxxx        xxxx                 xx   xx    \s
                         xx              xx               xx     xx   \s
                        xx                xx              x       x   \s
                        x                  x                          \s
                        """);
                break;
            default: break;
        }
    }
}
