# nt2_android_project
TP Final para Nuevas Tecnologias 2. Aplicacion android para carga de dedicaciones

## Requerimientos:
* *Java JDK*
* *Android Studio*
* *SDK Packages*

        emulator
        platform-tools
        tools
        build-tools
        extras;google;google_play_services
        
* *Variables de entorno:*

    `JAVA_HOME`  
    `ANDROID_HOME`  
    `PATH: Add`
    
      $JAVA_HOME/bin
      $ANDROID_HOME/platform-tools
      $ANDROID_HOME/tools/bin
      $ANDROID_HOME/emulator
      
* *HyperV enable (BIOS Setting)*  

**Nota**: En algunas maquina puede ser necesario instalar via **sdkmanager** el paquete `extras;intel;Hardware_Accelerated_Execution_Manager`

## Crear device via AVD Manager
* Desde Android Studio presionar `Ctrl + Shift + A` escribir **AVD Manager** y seleccionar opcion
* Seleccionar opcion **Create Virtual Device**
* Seleccionar la opcion **Phone** en **Category**
* Seleccionar un modelo de Device (Preferiblemente uno que tenga el icono de la Play Store). Ej: `Pixel 2`
* **Next**
* Seleccionar una imagen que posea **Google Play**. Ej: `Oreo API 26 x86`
* Setearle un nombre al Device (`AVD Name`)
* **Finish**

## Ejecutar device
Para ejecutar el device puede realizarse via IDE (Android Studio) o via command line
#### Via Android Studio
* Abrir la ventana **AVD Manager** (ver primer paso de [Crear Device via AVD Manager](#crear-device-via-avd-manager))
* Seleccionr el device y darle click al boton play verde
### Via Command Line
Es necesario haber seteado las **Variables de Entorno** y en el **Path** haber agregado al menos la carpeta `emulator`
* Desde **CMD** o **Powershell ejecutar** `emulator -avd "<device_name>"`  
**Nota**: Si el device name contiene espacio, sera necesario sustiturlos por underlines (**_**) . ej:`my_device_name`
