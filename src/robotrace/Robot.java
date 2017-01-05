package robotrace;

import com.jogamp.opengl.util.gl2.GLUT;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import static javax.media.opengl.GL2.*;

/**
* Represents a Robot, to be implemented according to the Assignments.
*/
class Robot {
    
    /** The position of the robot. */
    public Vector position = new Vector(0, 0, 0);
    
    /** The direction in which the robot is running. */
    public Vector direction = new Vector(1, 0, 0);

    /** The material from which this robot is built. */
    private final Material material;
    
    

    /**
     * Constructs the robot with initial parameters.
     */
    public Robot(Material material
            
    ) {
        this.material = material;

        
    }

    /**
     * Draws this robot (as a {@code stickfigure} if specified).
     */
    public void draw(GL2 gl, GLU glu, GLUT glut, float tAnim) {
        ShaderPrograms.robotShader.setUniform(gl, "useTexture", 0);

        int uniformLoc = gl.glGetUniformLocation(ShaderPrograms.robotShader.getProgramID(), "useTexture");
        gl.glUniform1i(uniformLoc, 0);

        gl.glActiveTexture(GL_TEXTURE0);
        Textures.head.bind(gl);

        gl.glPushMatrix();
        gl.glScaled(2, 1, 4);
        glut.glutSolidCube(1);
        gl.glPopMatrix();
    }
    
    
}
