package com.example.informesgabrielaworld;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.control.ToggleGroup;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

/**
 * La clase InformeController: Es el controlador de la interfaz gráfica de la aplicacion
 * Se encarga de recoger las opciones que elige el usuario y generar un informe en formato PDF acorde.
 *
 * @author Gabriela Jiménez Morcillo
 * @version 1.0
 */
public class InformeController {
    @FXML
    private Label labelHelp;
    @FXML
    private TextField TXNombre;
    @FXML
    private Button ButtonClear;

    @FXML
    private Button ButtonGenerate;

    @FXML
    private Button ButtonOpen;

    @FXML
    private Button ButtonEspania;

    @FXML
    private ComboBox<String> CBCountry;

    @FXML
    private ComboBox<String> CBLanguage;

    @FXML
    private ProgressBar ProgressBar;

    @FXML
    private ToggleGroup Continentes;

    @FXML
    private RadioButton Europe;

    @FXML
    private RadioButton Asia;

    @FXML
    private RadioButton SouthAmerica;

    @FXML
    private RadioButton Oceania;

    @FXML
    private RadioButton NorthAmerica;

    @FXML
    private RadioButton Africa;

    @FXML
    private ImageView imageView;

    /**
     * El metodo initialize: inicia la interfaz gráfica y carga los valores tipo string dentro de los Combo Box de Languaga y Country
     * Además maneja el evento del click en el label Help
     *
     */
    @FXML
    public void initialize() {
        //Inicializar paises
        CBCountry.getItems().addAll(
                "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola",
                "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba",
                "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh",
                "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan",
                "Bolivia", "Bosnia and Herzegovina", "Botswana", "Bouvet Island", "Brazil",
                "British Indian Ocean Territory", "Brunei", "Bulgaria", "Burkina Faso", "Burundi",
                "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands",
                "Central African Republic", "Chad", "Chile", "China", "Christmas Island",
                "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo",
                "Congo, The Democratic Republic of the", "Cook Islands", "Costa Rica", "Croatia",
                "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica",
                "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea",
                "Eritrea", "Estonia", "Eswatini", "Ethiopia", "Falkland Islands", "Faroe Islands",
                "Fiji Islands", "Finland", "France", "French Guiana", "French Polynesia",
                "French Southern territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana",
                "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala",
                "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Heard Island and McDonald Islands",
                "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq",
                "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya",
                "Kiribati", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia",
                "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macao", "Madagascar", "Malawi",
                "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania",
                "Mauritius", "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova", "Monaco",
                "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal",
                "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger",
                "Nigeria", "Niue", "Norfolk Island", "North Korea", "North Macedonia", "Northern Mariana Islands",
                "Norway", "Oman", "Pakistan", "Palau", "Palestine", "Panama", "Papua New Guinea", "Paraguay",
                "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico", "Qatar", "Romania",
                "Russian Federation", "Rwanda", "Saint Helena", "Saint Kitts and Nevis", "Saint Lucia",
                "Saint Pierre and Miquelon", "Saint Vincent and the Grenadines", "Samoa", "San Marino",
                "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone",
                "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa",
                "South Georgia and the South Sandwich Islands", "South Korea", "Spain", "Sri Lanka", "Sudan",
                "Suriname", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand",
                "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan",
                "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates",
                "United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan",
                "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Virgin Islands, British", "Virgin Islands, U.S.",
                "Western Sahara", "Yemen", "Zambia", "Zimbabwe"
        );

        //Inicializar idiomas
        CBLanguage.getItems().addAll(
                "Afrikaans", "Albanian", "Amharic", "Arabic", "Armenian", "Azerbaijani", "Basque", "Belarusian", "Bengali",
                "Bosnian", "Bulgarian", "Catalan", "Cebuano", "Chichewa", "Chinese", "Corsican", "Croatian", "Czech",
                "Danish", "Dutch", "English", "Esperanto", "Estonian", "Filipino", "Finnish", "French", "Frisian", "Galician",
                "Georgian", "German", "Greek", "Gujarati", "Haitian Creole", "Hausa", "Hawaiian", "Hebrew", "Hindi", "Hmong",
                "Hungarian", "Icelandic", "Igbo", "Indonesian", "Irish", "Italian", "Japanese", "Javanese", "Kannada", "Kazakh",
                "Khmer", "Kinyarwanda", "Korean", "Kurdish (Kurmanji)", "Kyrgyz", "Lao", "Latin", "Latvian", "Lithuanian",
                "Luxembourgish", "Macedonian", "Malagasy", "Malay", "Malayalam", "Maltese", "Maori", "Marathi", "Mongolian",
                "Myanmar (Burmese)", "Nepali", "Norwegian", "Odia (Oriya)", "Pashto", "Persian", "Polish", "Portuguese",
                "Punjabi", "Romanian", "Russian", "Samoan", "Scots Gaelic", "Serbian", "Sesotho", "Shona", "Sindhi",
                "Sinhala", "Slovak", "Slovenian", "Somali", "Spanish", "Sundanese", "Swahili", "Swedish", "Tajik", "Tamil",
                "Tatar", "Telugu", "Thai", "Turkish", "Turkmen", "Ukrainian", "Urdu", "Uyghur", "Uzbek", "Vietnamese",
                "Welsh", "Xhosa", "Yiddish", "Yoruba", "Zulu"
        );

        labelHelp.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                abrirManual();
            }
        });
    }

    /**
     * El metodo ButtonGenerate: define la accion que realiza la aplicacion cuando el usuario pulse el botón generate report
     * Este método sirve para generar un informe customizado por el usuario
     * Se conecta con la base de datos de mariadb y guarda en mapas los valores seleccionados por los usuarios (en Combo Boxes, y Radio Button) y los pasa como parámetros para generar los informes.
     * También define el comportamiento de una barra de carga que simula la generación del informe en tiempo real. La barra de carga avanza en 4 tandas esperando un tiempo determinado entre avances
     * Finalmente, el meodo genera los informes Jasper en formato pdf y con un nombre elegido por el usuario
     *
     * @param actionEvent es el parametro que lanza la accion del boton cuando es clickado
     */
    @FXML
    public void ButtonGenerate(ActionEvent actionEvent) {
        //Crear un Task para la barra de tareas que es como un hilo
        Task<Void> generateTask = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    //Establecer el progreso inicial de la barra de carga
                    updateProgress(0, 100);

                    //Conexión a la base de datos
                    Class.forName("org.mariadb.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/world", "root", "");

                    //Obtener los valores de los combo box
                    String selectedCountry = CBCountry.getValue() != null ? CBCountry.getValue().toString() : null;
                    String selectedLanguage = CBLanguage.getValue() != null ? CBLanguage.getValue().toString() : null;
                    String selectedContinent = null;

                    //Para saber que está seleccionado en el radio button
                    Toggle selectedToggle = Continentes.getSelectedToggle();
                    if (selectedToggle != null) {
                        selectedContinent = ((RadioButton) selectedToggle).getText();
                    }

                    //Guardar los parametros en el mapa
                    Map<String, Object> parametros = new HashMap<>();
                    if (selectedCountry != null) {
                        parametros.put("País", selectedCountry);
                    }
                    if (selectedLanguage != null) {
                        parametros.put("Idioma", selectedLanguage);
                    }
                    if (selectedContinent != null) {
                        parametros.put("Continente", selectedContinent);
                    }

                    for (int i = 1; i <= 4; i++) {
                        //simulamos que tarda un poco
                        Thread.sleep(400);
                        double progress = (double) i / 4;
                        //Actualizamos el progreso por pasos
                        updateProgress(progress, 1);
                    }

                    //La generación de los jaspers
                    JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream("/ArchivosJasper/InformeGabriela.jasper"),parametros,connection);
                    String nombrePDF=TXNombre.getText();
                    JasperExportManager.exportReportToPdfFile(print,"src/main/resources/InformesGenerados/"+nombrePDF+".pdf");

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        };

        //Vinculamos la barra de progreso a la task
        ProgressBar.progressProperty().bind(generateTask.progressProperty());

        // Iniciar el Task en un nuevo hilo
        new Thread(generateTask).start();
    }

    /**
     * El metodo ButtonEspania: funciona igual que el metodo ButtonGenerar.
     * La unica diferencia es que en este metodo los valores que se pasan al mapa ya están predefinidos
     * De esta forma siempre se generara el mismo informe solo con los valores de nuestro país
     *
     * @param actionEvent es el parametro que lanza la accion del boton cuando es clickado
     */
    @FXML
    public void ButtonEspania(ActionEvent actionEvent) {
        Task<Void> generateTask = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    updateProgress(0, 100);

                    Class.forName("org.mariadb.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/world", "root", "");

                    for (int i = 1; i <= 4; i++) {
                        Thread.sleep(400);
                        double progress = (double) i / 4;
                        updateProgress(progress, 1);
                    }
                    Map<String, Object> parametrosSpain = new HashMap<>();
                    parametrosSpain.put("Continente", "Europe");
                    parametrosSpain.put("País", "Spain");
                    parametrosSpain.put("Idioma", "Spanish");


                    JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream("/ArchivosJasper/InformeGabrielaSpain.jasper"),parametrosSpain,connection);
                    JasperExportManager.exportReportToPdfFile(print,"src/main/resources/InformesGenerados/InformeSpain.pdf");

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        };

        ProgressBar.progressProperty().bind(generateTask.progressProperty());
        new Thread(generateTask).start();
    }

    /**
     * El metodo ButtonOpen: define la accion que realiza la aplicación cuando el usuario pulse el boton open folder
     * Este metodo sirve para abrir la carpeta contenedora de los informes que genera la aplicacion
     * Comprueba si la carpeta existe y comprueba cual es el sistema operativo del usuario para lanzar la order predeterminada y abrir la carpeta
     *
     * @param actionEvent es el parametro que lanza la accion del boton cuando es clickado
     */
    //Action event que abre la carpeta donde se generan los archivos
    @FXML
    public void ButtonOpen (ActionEvent actionEvent) {
        try {
            //File folder = new File("/home/alumno/Escritorio/DAM2/DESARROLLO DE INTERFACES/JASPERWORLD/InformesGabrielaWorld/src/main/resources/InformesGenerados/");
            //File folder = new File("G:\\DAM\\SEGUNDO\\INTERFACES\\SEGUNDO TRIMESTRE\\InformesGabrielaWorld-master\\src\\main\\resources\\InformesGenerados");
            File folder = new File ("src/main/resources/InformesGenerados");

            //Verificamos si la carpeta existe
            if (folder.exists() && folder.isDirectory()) {
                String sistemaOperativo = System.getProperty("os.name").toLowerCase();
                if (sistemaOperativo.contains("win")) {
                    //Si la carpeta existe la abrimos
                    Desktop.getDesktop().open(folder);
                } else if (sistemaOperativo.contains("nix") || sistemaOperativo.contains("nux")) {
                    //Para LInux
                    Runtime.getRuntime().exec(new String[]{"xdg-open", folder.getAbsolutePath()});
                }
            } else {
                System.out.println("La carpeta no existe.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * El metodo ButtonClear: define la accion que realiza la aplicacion cuando el usuario pulse el botón clear fields
     * Este metodo sirve para resetear la barra de carga y los valores seleecionados por el usuario
     *
     * @param actionEvent es el parametro que lanza la accion del boton cuando es clickado
     */
    //Método para limpiar los campos
    @FXML
    public void ButtonClear(ActionEvent actionEvent) {
        CBCountry.setValue(null);
        CBCountry.setPromptText(CBCountry.getPromptText());
        CBLanguage.setValue(null);
        CBLanguage.setPromptText(CBLanguage.getPromptText());
        TXNombre.setText("");

        if (Continentes.getSelectedToggle() != null) {
            Continentes.getSelectedToggle().setSelected(false);
        }
        ProgressBar.progressProperty().unbind();
        ProgressBar.setProgress(0);
    }

    /**
     * El metodo abrirManual: define la acción que realiza la aplicación cuando el usuario haga click en el label Help
     * Tiene un achivo que apunta a la ruta en la que se encuentra el manual de usuario en html
     * Detecta el sistema operativo del usuario y abre en el navegador el html del manual de usuario
     */
    public void abrirManual(){
        try{
            File manualHTML= new File("src/main/resources/ManualUsuario/ManualUsuario.html");
            String sistemaOperativo = System.getProperty("os.name").toLowerCase();
            if (sistemaOperativo.contains("win")) {
                Desktop.getDesktop().browse(manualHTML.toURI());
            } else if (sistemaOperativo.contains("nix") || sistemaOperativo.contains("nux")) {
                //Para LInux
                Runtime.getRuntime().exec(new String[]{"xdg-open", manualHTML.getAbsolutePath()});
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}