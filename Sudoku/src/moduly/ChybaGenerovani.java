/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moduly;

/**
 *
 * @author Oldřich
 */
public class ChybaGenerovani extends Exception {

    /**
     * Creates a new instance of <code>ChybaGenerovani</code> without detail
     * message.
     */
    public ChybaGenerovani() {
    }

    /**
     * Constructs an instance of <code>ChybaGenerovani</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public ChybaGenerovani(String msg) {
        super(msg);
    }
}
