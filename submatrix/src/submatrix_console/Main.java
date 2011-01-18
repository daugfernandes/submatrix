/*
 *
 *     Copyright (C) 2010  David Fernandes
 *
 *                         Rua da Quinta Amarela, 60
 *                         4475-663 MAIA
 *                         PORTUGAL
 *
 *                         <daugfernandes@aim.com>
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package submatrix_console;

import submatrix.*;

import java.util.ArrayList;
import java.io.*;

/**
 *
 * @author david
 */
public class Main {

    private static cEngine _engine;
    private static cGame _game;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /* Inicialização da máquina de jogo
         */

        _game=new cGame();
        _engine=new cEngine(_game);

        /* Inicialização dos 2 realms solicitados (hardcoded)
         * Este processo pode ser interactivo, no sentido de permitir
         * a adição de outros realms com o jogo a correr.
         */

        _game.addRealm(new cRealm("MATRIX",new cPlane()));
        _game.addRealm(new cRealm("EARTH",new cPlane()));

        console();

    }

    /**
     *
     */
    public static void console() {

        String com="";
        boolean exit=false;

        header();

        while(!exit) {
            System.out.print("> ");
            com=null;
            com=readConsole(System.in);
            if(com==null) System.out.println("x: Erro de leitura da consola.");

            if(com.equalsIgnoreCase("Q"))
                exit=true;
            else {
                parse(com);
            }
        }
    }

    private static void parse(String p_command) {
        /*
         * Faz o split por ' ' <espaço>
         */
        String[] coms = p_command.split(" ");

        if(coms.length>0) {

            /* Help
             * Uso:
             *       ?
             */
            if(coms[0].equalsIgnoreCase("?")) {
                help();
            }

            /* LoadScript
             * Uso:
             *       LS nomeficheiro
             */
            if(coms[0].equalsIgnoreCase("LS")){
                if(coms.length<3)
                    usage("LS");
                else {
                    cScript p=new cScript();
                    String msg=p.load(coms[1],coms[2]);
                    if(msg!=null)
                        System.out.println("x: Comando LS -> Erro ("+msg+")");
                    else
                    {
                        if(_engine.addScript(p))
                            System.out.println("i: Script ["+coms[2]+"] adicionado.");
                        else
                            System.out.println("x: Script ["+coms[2]+"] não adicionado. Nome repetido.");
                    }
                }
            }

            /* AddRealm
             * Uso:
             *       AR nome
             */
            if(coms[0].equalsIgnoreCase("AR")){
                if(coms.length<2)
                    usage("AR");
                else {

                    if(_game.addRealm(new cRealm(coms[1], new cPlane())))
                        System.out.println("i: Realm ["+coms[1]+"] adicionado.");
                    else
                        System.out.println("x: Realm ["+coms[1]+"] não adicionado. Nome repetido.");

                }
            }

            /* ListRealms
             * Uso:
             *       LR
             */
            if(coms[0].equalsIgnoreCase("LR")){
                if(coms.length!=1)
                    usage("LR");
                else {
                    ArrayList<cRealm> r=_game.getRealms();
                    for(int i=0;i<r.size();i++) {
                        System.out.println("i: " + r.get(i).toString());
                    }

                }
            }
        }
    }

    private static void usage(String p_command) {

        if(p_command.equalsIgnoreCase("LR")) {
            System.out.println("h: LR                               (lista realms)");
        }

        if(p_command.equalsIgnoreCase("AR")) {
            System.out.println("h: AR <nome>                        (adicionar realm)");
        }

        if(p_command.equalsIgnoreCase("LS")) {
            System.out.println("h: LS <ficheiro> <nome_script>      (load de script)");
        }

        if(p_command.equalsIgnoreCase("Q")) {
            System.out.println("h: Q                                (termina o jogo)");
        }

        if(p_command.equalsIgnoreCase("?")) {
            System.out.println("h: ?                                (lista de comandos)");
        }

    }


    private static void header() {
        System.out.println("h: ");
        System.out.println("h: subMatrix!!");
        System.out.println("h: ");
        System.out.println("h:   por David Fernandes <daugfernandes@aim.com>");
        System.out.println("h: ");
        System.out.println("h: ");
    }

    private static void help() {
        header();
        usage("AR");
        usage("LR");
        usage("LS");
        usage("Q");
        usage("?");
        System.out.println("h: ");
    }


    /**
     * Lê sequência de carácteres de um stream de input
     * @param p_stream Inputstream - System.in para o teclado, por exemplo
     * @return a string digitada.
     */
    public static String readConsole(InputStream p_stream) {

      BufferedReader br = new BufferedReader(new InputStreamReader(p_stream));
      String ret = null;
      try {
         ret = br.readLine();
      } catch (IOException ioe) {
            return ret;
      }
      return ret;
    }

}
