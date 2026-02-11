package com.santiagom123.minewiki.handler;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.apache.logging.log4j.Logger;

public class HandlerEXT {


    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger("MineWiki");

    public static void extractJar(FMLPreInitializationEvent e) {
        try {
            String nameJar = "MineWikiEXT.jar";
            File fileJarTar = new File(e.getModConfigurationDirectory().getParentFile(), nameJar);

            if (!fileJarTar.exists()) {

                for (int i = 0; i < 50; i++) {
                    logger.info("========================================================================================");
                }

                logger.warn("No such file: {}, this will create this file", nameJar);
                URL ExtURL = HandlerEXT.class.getClassLoader().getResource("minewiki/minewikiext/" + nameJar);



                if (ExtURL != null) {
                    logger.warn("URL of EXT: {}", ExtURL.toString());
                    FileUtils.copyURLToFile(ExtURL, fileJarTar);
                    logger.warn("File {} copied from source to {}", nameJar, fileJarTar.getAbsolutePath());
                } else {
                    logger.error("Source file not found");
                }
            }
        } catch (IOException ex) {
            logger.error("Error while extracting MineWikiEXT.jar", ex);
        }
    }


}
