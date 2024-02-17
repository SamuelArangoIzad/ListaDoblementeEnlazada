package listadoblementeenlazada.co.edu.upb;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Goal which touches a timestamp file.
 *
 * @deprecated Don't use!
 */
@Mojo( name = "touch", defaultPhase = LifecyclePhase.PROCESS_SOURCES )
public class MyMojo
    extends AbstractMojo
{
    /**
     * Location of the file.
     */
    @Parameter( defaultValue = "${project.build.directory}", property = "outputDir", required = true )
    private File outputDirectory;

    public void execute()
        throws MojoExecutionException
    {
        File f = outputDirectory;

        if ( !f.exists() )
        {
            f.mkdirs();
        }

        File touch = new File( f, "touch.txt" );

        FileWriter w = null;
        try
        {
            w = new FileWriter( touch );

            w.write( "touch.txt" );
        }
        catch ( IOException e )
        {
            throw new MojoExecutionException( "Error creating file " + touch, e );
        }
        finally
        {
            if ( w != null )
            {
                try
                {
                    w.close();
                }
                catch ( IOException e )
                {
                    // ignore
                }
            }
        }
    }
}
/**
 * Este código es un complemento de Maven, una herramienta de construcción y gestión de proyectos de software. Este complemento define un "mojo" (un objetivo de Maven) llamado "touch". 

El objetivo de este mojo es crear un archivo de marca de tiempo llamado "touch.txt" en el directorio de salida del proyecto, que es el directorio de construcción `${project.build.directory}`.

El código define el comportamiento del mojo a través del método `execute()`, que crea un archivo llamado "touch.txt" en el directorio de salida y escribe el texto "touch.txt" en él.

Este código se puede ejecutar durante diferentes fases del ciclo de vida de Maven, ya que está anotado con `@Mojo(name = "touch", defaultPhase = LifecyclePhase.PROCESS_SOURCES)`. Sin embargo, cabe destacar que este mojo está marcado como obsoleto (`@deprecated`) y se recomienda no utilizarlo.
 * 
 */
