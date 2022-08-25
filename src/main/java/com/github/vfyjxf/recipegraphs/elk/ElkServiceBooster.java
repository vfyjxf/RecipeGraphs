package com.github.vfyjxf.recipegraphs.elk;

import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import org.eclipse.elk.alg.common.compaction.options.PolyominoOptions;
import org.eclipse.elk.alg.layered.options.LayeredMetaDataProvider;
import org.eclipse.elk.alg.layered.options.LayeredOptions;
import org.eclipse.elk.core.data.LayoutMetaDataService;
import org.eclipse.elk.core.labels.LabelManagementOptions;
import org.eclipse.elk.core.options.BoxLayouterOptions;
import org.eclipse.elk.core.options.CoreOptions;
import org.eclipse.elk.core.options.FixedLayouterOptions;
import org.eclipse.elk.core.options.RandomLayouterOptions;

import java.lang.reflect.InvocationTargetException;

public final class ElkServiceBooster {

    public synchronized static void init() {
        try {
            LayoutMetaDataService instance = (LayoutMetaDataService) LayoutMetaDataService.class.getDeclaredConstructors()[0].newInstance(new Object());
            ObfuscationReflectionHelper.setPrivateValue(
                    LayoutMetaDataService.class,
                    null,
                    instance,
                    "instance");
            instance.registerLayoutMetaDataProviders(new CoreOptions(),
                    new BoxLayouterOptions(),
                    new FixedLayouterOptions(),
                    new LabelManagementOptions(),
                    new LayeredMetaDataProvider(),
                    new LayeredOptions(),
                    new PolyominoOptions(),
                    new RandomLayouterOptions());

        } catch (InvocationTargetException| InstantiationException| IllegalAccessException exception){
            exception.printStackTrace();
        }
        try {
            Class.forName("org.eclipse.elk.core.service.ElkServicePlugin");
        } catch (Exception e) {
            // If the service plug-in is not available, that's no problem; we'll simply use our default factory
        }
    }

}
