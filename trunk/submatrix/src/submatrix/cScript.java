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

    submatrix::cScript.java

 */
/**
 * Programa
 * @author david
 */
public class cScript {

    /**
     * Enumeração de estados possíveis de um programa.
     */
    public enum eState {
        /**
         * Parado
         */
        Stoped,
        /**
         * Em execução
         */
        Running,
        /**
         * Interrompido
         */
        Paused
    }

    private ArrayList<cInstruction> _instructions;
    private String _name;
    private eState _status;
    private int _current_instruction_order;

    /**
     * Constructor
     */
    public cScript() {
        initialize();
    }

    private void initialize() {
        _instructions = new ArrayList<cInstruction>(0);
        _status=eState.Stoped;
        _current_instruction_order=0;
        _name="";
    }

    /**
     * Carrega um programa a partir de um ficheiro de texto
     * @param filename - nome do ficheiro que contém o programa a cartegar
     * @param p_progname
     * @return Indicador do sucesso do carregamento; null se bem sucedido ou
     * mensagem de erro se o carregamento não foi bem sucedido.
     */
    public String load(String filename, String p_progname) {

        // TODO: implementar
        initialize();
        _name=p_progname;
        return null;
    }

    /**
     * Selector do nome do programa
     * @return String
     */
    public String getName() {
        return _name;
    }

    /**
     * Selector do estado do programa
     * @return estado do programa (ver eState)
     */
    public eState getStatus() {
        return _status;
    }

    /**
     * Modificadeor do estado do programa.
     * @param p_state - estado do programa
     */
    public void setStatus(eState p_state) {
        _status=p_state;
    }

    /**
     * Pesquisar instrucção por número de ordem
     * @param p_order - número de ordem da instrucção
     * @return cInstruction
     */
    public cInstruction getInstructionByOrder(int p_order) {
        for(int i=0;i<_instructions.size();i++)
            if(_instructions.get(i).getOrder()==p_order)
                return _instructions.get(i);
        return null;
    }

    /**
     * Modificador
     * @param p_order - ordem da instrucção a executar
     */
    public void setCurrentInstructionOrder(int p_order) {
        _current_instruction_order=p_order;
    }

    /**
     * Selector
     * @return - ordem da instrucção a executar
     */
    public int getCurrentInstructionOrder() {
        return _current_instruction_order;
    }

    /**
     * Adiciona instrucção ao programa
     * @param p_order - ordem da instrucção
     * @param p_command - comando
     * @return - indicador de sucesso da adição. Ordens repetidas invalidam a
     * adição.
     */
    public boolean addInstruction(int p_order, String p_command) {
        if(getInstructionByOrder(p_order)==null) {
            _instructions.add(new cInstruction(p_order, p_command));
            return true;
        }
        return false;
    }

    /**
     * Executa a instrucção actual e actualiza a instrucção a executar de
     * seguida
     * @param _game - jogo sobre o qual se vai executar a instrucção
     * @return Indicador do sucesso da execução
     */
    public boolean stepRun(cGame _game) {
        // todo: implementar
        return true;
    }

}
