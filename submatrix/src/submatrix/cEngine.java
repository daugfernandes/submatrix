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

package submatrix;

import java.util.ArrayList;

/*

    submatrix::cEngine.java

 */
/**
 * Máquina de execução de scripts
 * @author david
 */
public class cEngine {

    private ArrayList<cScript> _scripts;
    private int _executing_script;
    private cGame _game;

    /**
     * Constructor
     * @param p_game - jogo sobre o qual serão executados os scripts
     */
    public cEngine(cGame p_game) {
        _scripts = new ArrayList<cScript>(0);
        _executing_script=-1;
        _game=p_game;
    }

    /**
     * Adiciona um script à máquina
     * @param p_script
     * @return 
     */
    public boolean addScript(cScript p_script) {

        /* Não pode haver dois scripts com o mesmo nome */
        if(getScriptByName(p_script.getName())!=null)
            return false;
        else {
            p_script.setStatus(cScript.eState.Stoped);
            _scripts.add(p_script);
            return true;
        }
    }

    /**
     * Pesquisa script por nome
     * @param p_name - nome do script
     * @return
     */
    public cScript getScriptByName(String p_name) {
        for(int i=0;i<_scripts.size();i++) {
            cScript p=_scripts.get(i);
            if(p.getName().equalsIgnoreCase(p_name))
                return p;
        }
        return null;
    }

    /**
     * Executa um passo (script a script em círculo - uma instrucção para cada um)
     * @return
     */
    public cScript stepRun() {

        cScript script=null;

        // programa a executar
        int nextscript=_executing_script+1;

        boolean done=false;

        /* Ciclo de execução
         * Procura próximo script a executar e sai se não há scripts a
         * executar (por estarem todos stopped, por exemplo) ou se conseguiu
         * executar.
         */
        while(nextscript!=_executing_script && !done) {

            // final do vector de scripts, volta ao início
            if(nextscript>=_scripts.size()) nextscript=0;

            // obtêm script
            script=_scripts.get(nextscript);

            // verifica estado
            if(script.getStatus()!=cScript.eState.Running)

                // parado, procura próximo
                nextscript++;

            else

                // tenta executar uma instrucção
                done=script.stepRun(_game);
        
        }

        /* retorna o programa cuja instrucção acabou de executar
         * ou null se não conseguiu executar nenhuma instrucção
         */
        return (done?script:null);
    }

}
