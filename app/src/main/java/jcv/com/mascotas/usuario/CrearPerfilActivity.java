package jcv.com.mascotas.usuario;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import jcv.com.mascotas.R;
import jcv.com.mascotas.login.LoginActivity;
import jcv.com.mascotas.modelo.Usuario;
import jcv.com.mascotas.servicios.ServicioPublicacion;
import jcv.com.mascotas.servicios.ServicioUsuario;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class CrearPerfilActivity extends AppCompatActivity {
    private ImageView regresar;
    private TextView nombreCabecera;
    private Button btnSave;
    private EditText nombre;
    private EditText apellido;
    RadioButton rb;
    private EditText Email;
    private EditText Telefono;
    Spinner departamento;
    Spinner provincia;
    Spinner distrito;
    private EditText Contrasena;
    private EditText RepeteContrasena;
    String sexo = "M";
    List<String[]> ubigeo;
    List<List<String[]>> ubigeoDistrito;
    int provinciaSeleccionada = 0;


    String[] datosdepartamento={"Amazonas","Ancash","Apurimac","Arequipa","Ayacucho","Cajamarca","Cusco", "Huancavelica","Huanuco","Ica","Junin","La Libertad", "Lambayeque", "Lima","Loreto","Madre de Dios","Moquegua","Pasco","Piura","Puno", "San Martin","Tacna","Tumbes","Ucayali"};


    String[]Amazonas={"Bagua "," Bongara","Chachapoyas ","Chachapoyas","Condorcanqui ","Luya","Rodriguez de Mendoza ","Utcubamba"};
    String[]Ancash={"Aija ","Antonio Raymondi ","Asuncion ","Bolognesi ","Carhuaz","Carhuaz","Carlos Fermin Fitzcarrald ","Casma","Corongo ","Huaraz","Huari","Huarmey ","Huaylas","Mariscal Luzuriaga ","Ocros ","Pallasca ","Pomabamba ","Recuay ","Santa ","Sihuas ","Yungay"};
    String[]Apurimac={"Abancay","Andahuaylas","Antabamba","Aymaraes","Cotabambas","Chincheros",};
    String[]Arequipa={"Arequipa ","Camana ","Caraveli","Castilla","Caylloma ","Condesuyos","Islay","La Union"};
    String[]Ayacucho={"Cangallo","Huamanga","Huanca Sancos","Huanta","La Mar","Lucanas","Parinacochas","Paucar del Sara Sara","Sucre","Victor Fajardo","Vilcas Huaman"};
    String[]Cajamarca={"Cajabamba","cajamarca","Celendin","Chota","Contumaza","Cutervo","Hualgayoc","Jaen","San Ignacio ","San Marcos","San Miguel","San Pablo","Santa Cruz"};
    String[]Cusco={"Acomayo","Anta","Calca","Canas","Canchis","Chumbivilcas","Cusco","Espinar","La Convencion","Paruro","Paucartambo","Quispicanchi","Urubamba"};
    String[]Huancavelica={"Acobamba","Angaraes","Castrovirreyna","Churcampa","Huancavelica","Huaytara ","Tayacaja"};
    String[]Huanuco={"Ambo","Dos de Mayo","Huacaybamba","Huamalies","Huanuco","Lauracocha","Leoncio Prado","Maraqon","Pachitea","Puerto Inca","Yarowilca"};
    String[]Ica={"Chincha","Ica","Nazca","Palpa","Pisco"};
    String[]Junin={"Chanchamayo","Chupaca","Concepcion","Huancayo","Jauja","Junin","Satipo","Tarma","Yauli"};
    String[]LaLibertad={"Asco qpe","Bolivar","Chepen","Gran Chimu","Julcan","Otuzco","Pacasmayo","Pataz","Sanchez Carrion","Santiago de Chuco","Trujillo","Viru",};
    String[]Lambayeque={"Chiclayo","Ferreñafe","Lambayeque"};
    String[]Lima={"Barranca","Cajatambo","Callao","Canta","Cañete","Huaral","Huarochiri","Huaura","Lima","Oyon","Yauyos"};
    String[]Loreto={"Alto Amazonas","Loreto","Mariscal Ramon Castilla","Maynas","Requena","Ucayali"};
    String[]MadredeDios={"Manu","Tahuamanu","Tambopata"};
    String[]Moquegua={"General Sanchez Cerro","Ilo","Mariscal Nieto","Daniel Alcides Carrion"};
    String[]Pasco={"Oxapampa","Pasco"};
    String[]Piura={"Ayabaca","Huancabamba","Morropon","Paita","Piura","Sechura","Sullana","Talara"};
    String[]Puno={"Azangaro","Carabaya","Chucuito","El Collao","Huancane","Lampa","Melgar","Moho","Puno"," San Antonio de Putina","San Roman","Sandia","Yunguyo"};
    String[]SanMartin={"Bellavista","El Dorado","Huallaga","Lamas","Mariscal Caceres","Moyobamba","Picota","Rioja","San Martin","Tocache"};
    String[]Tacna={"Candarave","Jorge Basadre","Tacna","Tarata",};
    String[]Tumbes={"Contralmirante Villar","Tumbes","Zarumilla"};
    String[]Ucayali={"Atalaya","Coronel Portillo","Padre Abad","Purus",};

    //Amazonas
    String[]Bagua={"Aramango","Copallin","El Parco","Imaza","La Peca"};
    String[]Bongara={"Chisquilla", "Churuja","Corosha","Cuispes","Florida","Jazan","Jumbilla","Recta","San Carlos","Shipasbamba","Valera","Yambrasbamba"};
    String[]Chachapoyas={"Asuncion","Balsas","Chachapoyas","Cheto","Chiliquin","Chuquibamba","Granada","Huancas","La Jalca","Leimebamba","Levanto","Magdalena","Mariscal Castilla","Molinopampa","Montevideo","Olleros","Quinjalca","San Francisco de Daguas","San Isidro de Maino","Soloco","Sonche"};
    String[]Condorcanqui={"El Cenepa","Nieva","Rio Santiago"};
    String[]Luya={"Camporredondo","Cocabamba","Colcamar","Conila","Inguilpata","Lamud","Longuita","Lonya Chico","Luya","Luya Viejo","Maria","Ocalli","Ocumal","Pisuquia","Providencia","San Cristobal","San Francisco del Yeso","San Jeronimo","San Juan de Lopecancha","Santa Catalina","Santo Tomas","Tingo","Trita"};
    String[]RodriguezdeMendoza={"Chirimoto","Cochamal","Huambo","Limabamba","Longar","Mariscal Benavides","Milpuc","Omia","San Nicolas","Santa Rosa","Totora","Vista Alegre"};
    String[]Utcubamba={"Bagua Grande","Cajaruro","Cumba","El Milagro","Jamalca","Lonya Grande","Yamon"};

    //Ancash
    String[]Aija={"Aija","Coris","Huacllan","La Merced","Succha",};
    String[]AntonioRaymondi={"Aczo","Chaccho","Chingas","Llamellin","Mirgas","San Juan de Rontoy"};
    String[]Asuncion= {"Acochaca","Chacas"};
    String[]Bolognesi= {"Abelardo Pardo Lezameta","Antonio Raymondi","Aquia","Cajacay","Canis","Chiquian","Colquioc","Huallanca","Huasta","Huayllacayan","La Primavera","Mangas","Pacllon","San Miguel de Corpanqui","Ticllos",};
    String[]Carhuaz={"Acopampa","Amashca","Anta","Ataquero","Carhuaz","Marcara","Pariahuanca","San Miguel de Aco","Shilla","Tinco","Yungar"};
    String[]CarlosFerminFitzcarrald={"San Luis","San Nicolas","Yauya",};
    String[]Casma={"Buena Vista Alta","Casma","Comandante Noel","Yautan"};
    String[]Corongo={"Aco","Bambas","Cusca","La Pampa","Yanac","Yupan",};
    String[]Huaraz={"Cochabamba","Colcabamba","Huanchay","Huaraz","Independencia","Jangas","La Libertad","Olleros","Pampas","Pariacoto","Pira","Tarica",};
    String[]Huari={"Anra","Cajay","Chavin de Huantar","Huacachi","Huacchis","Huachis","Huantar","Huari","Masin","Paucas","Ponto","Rahuapampa","Rapayan","San Marcos","San Pedro de Chana","Uco",};
    String[]Huarmey={"Cochapeti","Culebras","Huarmey","Huayan","Malvas",};
    String[]Huaylas={"Caraz","Huallanca","Huata","Huaylas","Mato","Pamparomas","Pueblo Libre","Santa Cruz","Santo Toribio","Yuracmarca",};
    String[]MariscalLuzuriaga={"Casca","Eleazar Guzman Barron","Fidel Olivas Escudero","Llama","Llumpa","Lucma","Musga","Piscobamba"};
    String[]Ocros={"Acas","Cajamarquilla","Carhuapampa","Cochas","Congas","Llipa","Ocros","San Cristobal de Rajan","San Pedro","Santiago de Chilcas",};
    String[]Pallasca={"Bolognesi","Cabana","Conchucos","Huacaschuque","Huandoval","Lacabamba","Llapo","Pallasca","Pampas","Santa Rosa","Tauca",};
    String[]Pomabamba={"Huayllan","Parobamba","Pomabamba","Quinuabamba"};
    String[]Recuay={"Catac","Cotaparaco","Huayllapampa","Llacllin","Marca","Pampas Chico","Pararin","Recuay","Tapacocha","Ticapampa"};
    String[]Santa= {"Caceres del Peru", "Chimbote", "Coishco", "Macate", "Moro", "Nepeqa", "Nuevo Chimbote", "Samanco"," Santa"};
    String[]Sihuas={"Acobamba","Alfonso Ugarte","Cashapampa","Chingalpo","Huayllabamba","Quiches","Ragash","San Juan","Sicsibamba","Sihuas"};
    String[]Yungay={"Cascapara","Mancos","Matacoto","Quillo","Ranrahirca","Shupluy","Yanama","Yungay"};

    //Apurimac
    String[]Abancay={"Abancay","Chacoche","Circa","Curahuasi","Huanipaca","Lambrama","Pichirhua","San Pedro de Cachora","Tamburco"};
    String[]Andahuaylas={"Andahuaylas","Andarapa","Chiara","Huancarama","Huancaray","Huayana","Kaquiabamba","Kishuara","Pacobamba","Pacucha","Pampachiri","Pomacocha","San Antonio de Cachi","San Jeronimo","San Miguel de Chaccrampa","Santa Maria de Chicmo","Tumay Huaraca","Turpo",};
    String[]Antabamba={"Antabamba","El Oro","Huaquirca","Juan Espinoza Medrano","Oropesa","Pachaconas","Sabaino"};
    String[]Aymaraes= {"Capaya","Caraybamba","Chalhuanca","Chapimarca","Colcabamba","Cotaruse","Huayllo","Justo Apu Sahuaraura","Lucre","Pocohuanca","San Juan de Chacqa","Saqayca","Soraya","Tapairihua","Tintay","Toraya","Yanaca"};
    String[]Chincheros={"Anco-Huallo","Chincheros","Cocharcas","Huaccana","Ocobamba","Ongoy","Ranracancha","Uranmarca"};
    String[]Cotabambas ={"Challhuahuacho","Cotabambas","Coyllurqui","Haquira","Mara","Tambobamba","Chuquibambilla"};
    String[]Grau={"Curasco","Curpahuasi","Gamarra","Huayllati","Mamara","Micaela Bastidas","Pataypampa","Progreso","San Antonio","Santa Rosa","Turpay","Vilcabamba","Virundo"};

    //Arequipa
    String[]arequipa={"Alto Selva Alegre","Arequipa","Cayma","Cerro Colorado","Characato","Chiguata","Jacobo Hunter","Jose Luis Bustamante y Rivero","La Joya","Mariano Melgar","Miraflores","Mollebaya","Paucarpata","Pocsi","Polobaya","Quequeqa","Sabandia","Sachaca","San Juan de Siguas","San Juan de Tarucani","Santa Isabel de Siguas","Santa Rita de Siguas","Socabaya","Tiabaya","Uchumayo","Vitor","Yanahuara","Yarabamba","Yura"};
    String[]Camana={"Camana","Jose Maria Quimper","Mariano Nicolas Valcarcel","Mariscal Caceres","Nicolas de Pierola","Ocoqa","Quilca","Samuel Pastor"};
    String[]Caraveli={"Acari","Atico","Atiquipa","Bella Union","Cahuacho","Caraveli","Chala","Chaparra","Huanuhuanu","Jaqui","Lomas","Quicacha","Yauca"};
    String[]Castilla={"Andagua","Aplao","Ayo","Chachas","Chilcaymarca","Choco","Huancarqui","Machaguay","Majes","Orcopampa","Pampacolca","Tipan","Uqon","Uraca","Viraco","Yanque"};
    String[] Caylloma={"Achoma","Cabanaconde","Callalli","Caylloma","Chivay","Coporaque","Huambo","Huanca","Ichupampa","Lari","Lluta","Maca","Madrigal","Majes","San Antonio de Chuca","Sibayo","Tapay","Tisco","Tuti","Yanque"};
    String[] Condesuyos={"Andaray","Cayarani","Chichas","Chuquibamba","Iray","Rio Grande","Salamanca","Yanaquihua"};
    String[] Islay={"Cocachacra","Dean Valdivia","Islay","Mejia","Mollendo","Punta de Bombon"};
    String[] LaUnion={"Alca","Charcana","Cotahuasi","Huaynacotas","Pampamarca","Puyca","Quechualla","Sayla","Tauria","Tomepampa","Toro","Cangallo","Chuschi","Los Morochucos","Maria Parado de Bellido","Paras","Totos"};

    //Ayacucho
    String[]Cangallo= {"Cangallo", "Chuschi","Los Morochucos", "Maria Parado de Bellido","Paras","Totos"};
    String[]Huamanga={"Acocro","Acos Vinchos","Ayacucho","Carmen Alto","Chiara","Jesus Nazareno","Ocros","Pacaycasa","Quinua","San Jose de Ticllas","San Juan Bautista","Santiago de Pischa","Socos","Tambillo","Vinchos",};
    String[]HuancaSancos= {"Carapo","Sacsamarca","Sancos","Santiago de Lucanamarca"};
    String[]Huanta={"Ayahuanco","Huamanguilla","Huanta","Iguain","Llochegua","Luricocha","Santillana","Sivia"};
    String[]LaMar={"Anco","Ayna","Chilcas","Chungui","Luis Carranza","San Miguel","Santa Rosa","Tambo"};
    String[]Lucanas={"Aucara","Cabana","Carmen Salcedo","Chaviqa","Chipao","Huac-Huas","Laramate","Leoncio Prado","Llauta","Lucanas","Ocaqa","Otoca","Puquio","Saisa","San Cristobal","San Juan","San Pedro","San Pedro de Palco","Sancos","Santa Ana de Huaycahuacho","Santa Lucia"};
    String[]Parinacocha={"Chumpi","Coracora","Coronel Castaqeda","Pacapausa","Pullo","Puyusca","San Francisco de Ravacayco","Upahuacho",};
    String[]PaucardelSaraSara ={"Colta","Corculla","Lampa","Marcabamba","Oyolo","Pararca","Pausa","San Javier de Alpabamba","San Jose de Ushua","Sara Sara",};
    String[]Sucre= {"Belen","Chalcos","Chilcayoc","Huacaqa","Morcolla","Paico","Querobamba","San Pedro de Larcay","San Salvador de Quije","Santiago de Paucaray","Soras"};
    String[]VictorFajardo ={"Alcamenca","Apongo","Asquipata","Canaria","Cayara","Colca","Huamanquiquia","Huancapi","Huancaraylla","Huaya","Sarhua","Vilcanchos"};
    String[]VilcasHuaman ={"Accomarca","Carhuanca","Concepcion","Huambalpa","Independencia","Saurama","Vilcas Huaman","Vischongo"};

    //Cajamarca
    String[]Cajabamba={"Cachachi","Condebamba","Sitacocha","Asuncion",};
    String[]cajamarca ={"Cajamarca","Chetilla","Cospan","Encaqada","Jesus","Llacanora","Los Baqos del Inca","Magdalena","Matara","Namora","San Juan",};
    String[]Celendin={"Celendin","Chumuch","Cortegana","Huasmin","Jorge Chavez","Jose Galvez","La Libertad de Pallan","Miguel Iglesias","Oxamarca","Sorochuco","Sucre","Utco",};
    String[]Chota={"Anguia","Chadin","Chalamarca","Chiguirip","Chimban","Choropampa","Chota","Cochabamba","Conchan","Huambos","Lajas","Llama","Miracosta","Paccha","Pion","Querocoto","Chota","San Juan de Licupis","Tacabamba","Tocmoche"};
    String[]Contumaza={"Chilete","Contumaza","Cupisnique","Guzmango","San Benito","Santa Cruz de Toled","Tantarica","Yonan"};
    String[]Cutervo={"Callayuc","Choros","Cujillo","Cutervo","La Ramada","Pimpingos","Querocotillo","San Andres de Cutervo","San Juan de Cutervo","San Luis de Lucma","Santa Cruz","Santo Domingo de la Capilla","Santo Tomas","Socota","Toribio Casanova",};
    String[]Hualgayoc={"Bambamarca","Chugur","Hualgayoc"};
    String[]Jaen={"Bellavista","Chontali","Colasay","Huabal","Jaen","Las Pirias","Pomahuaca","Pucara","Sallique","San Felipe","San Jose del Alto","Santa Rosa"};
    String[]SanIgnacio ={"Chirinos","Huarango","La Coipa","Namballe","San Ignacio","San Jose de Lourdes","Tabaconas"};
    String[]SanMarcos ={"Chancay","Eduardo Villanueva","Gregorio Pita","Ichocan","Jose Manuel Quiroz","Jose Sabogal","Pedro Galvez"};
    String[]SanMiguel ={"Bolivar","Calquis","Catilluc","El Prado","La Florida","Llapa","Nanchoc","Niepos","San Gregorio","San Miguel","San Silvestre de Cochan","Tongod","Union Agua Blanca",};
    String[]SanPablo ={"San Bernardino","San Luis","Tumbaden",};
    String[]SantaCruz={"Andabamba","Catache","Chancaybaqos","La Esperanza","Ninabamba","Pulan","Santa Cruz","Saucepampa","Sexi","Uticyacu","Yauyucan"};

    //Cusco
    String[]Acomayo={" Acomayo ","Acopia","Acos","Mosoc Llacta","Pomacanchi","Rondocan","Sangarara","Ancahuasi"};
    String[]Anta={"Anta","Cachimayo","Chinchaypujio","Huarocond","Limatambo","Mollepata","Pucyura","Zurite"};
    String[]Calca={"Calca","Coya","Lamay","Lares","Pisac","San Salvador","Taray","Yanatile"};
    String[]Canas={"Checca","Kunturkanki","Langui","Layo","Pampamarca","Quehue","Tupac Amaru","Yanaoca","Checacupe"};
    String[] Canchis={"Combapata","Marangani","Pitumarca","San Pablo","San Pedro","Sicuani","Tinta",};
    String[]Chumbivilcas={"Capacmarca","Chamaca","Colquemarca","Livitaca","Llusco","Quiqota", "Santo Tomas","Velille","Ccorca","Cusco","Poroy","San Jeronimo","San Sebastian","Santiago","Saylla","Wanchaq"};
    String[]Espinar={"Alto Pichigua","Condoroma","Coporaque","Espinar","Ocoruro","Pallpata","Pichigua","Suyckutambo","Echarate"};
    String[]LaConvencion={"Huayopata","Maranura","Ocobamba","Pichari","Quellouno","Quimbiri","Santa Ana","Santa Teresa","Vilcabamba"};
    String[]Paruro={"Accha","Ccapi","Colcha","Huanoquite","Omacha","Paccaritambo","Paruro","Pillpinto","Yaurisque"};
    String[]Paucartambo={"Caicay","Challabamba","Colquepata","Huancarani","Kosqipata","Paucartambo"};
    String[]Quispicanchi={"Andahuaylillas","Camanti","Ccarhuayo","Ccatca","Cusipata","Huaro","Lucre","Marcapata","Ocongate","Oropesa","Quiquijana","Urcos"};
    String[]Urubamba={"Chinchero","Huayllabamba","Machupicchu","Maras","Ollantaytambo","Urubamba","Yucay"};

    //Huancavelica
    String[] Acobamba ={"Acobamba","Andabamba","Anta","Caja","Marcas","Paucara","Pomacocha","Rosario"};
    String[]Angaraes ={"Anchonga","Callanmarca","Ccochaccasa","Chincho","Congalla","Huanca-Huanca","Huayllay Grande","Julcamarca","Lircay","San Antonio de Antaparco","Santo Tomas de Pata","Secclla"};
    String[]Castrovirreyna ={"Arma","Aurahua", "Capillas","Castrovirreyna","Chupamarca","Cocas","Huachos","Huamatambo","Mollepampa","San Juan","Santa Ana","Tantara","Ticrapo"};
    String[]Churcampa ={"Anco","Chinchihuasi","Churcampa","El Carmen","La Merced","Locroja","Pachamarca","Paucarbamba","San Miguel de Mayocc","San Pedro de Coris"};
    String[]huancavelica ={"Acobambilla","Acoria","Ascension","Conayca","Cuenca","Huachocolpa","Huancavelica","Huando","Huayllahuara","Izcuchaca","Laria","Manta","Mariscal Caceres","Moya","Nuevo Occoro","Palca","Pilchaca","Vilca","Yauli"};
    String[]Huaytara ={"Ayavi","Cordova","Huayacundo Arma","Huayacundo Arma","Huaytara","Laramarca","Ocoyo","Pilpichaca","Querco","Quito-Arma","San Antonio de Cusicancha","San Francisco de Sangayaico","San Isidro","Santiago de Chocorvos","Santiago de Quirahuara","Santo Domingo de Capillas","Tambo"};
    String[]Tayacaja={"Acostambo","Acraquia","Ahuaycha","Colcabamba","Daniel Hernandez","Huachocolpa","Huando","Huaribamba","Pachamarca","Pampas","Pazos","Qahuimpuquio","Quishuar","Salcabamba","Salcahuasi","San Marcos de Rocchac","Surcubamba","Tintay Puncu",};

    //Huanuco
    String[]Ambo={"Ambo","Cayna","Colpas","Conchamarca","Huacar","San Francisco","San Rafael","Tomay Kichwa",};
    String[]DosdeMayo= {"Chuquis","La Union","Marias","Pachas","Quivilla","Ripan","Shunqui","Sillapata","Yanas"};
    String[] Huacaybamba ={"Canchabamba","Cochabamba","Huacaybamba","Pinra",};
    String[]Huamalies={"Arancay","Chavin de Pariarca","Jacas Grande","Jircan","Llata","Miraflores","Monzon","Punchao","Puqos","Singa","Tantamayo"};
    String[]huanuco={"Amarilis","Chinchao","Churubamba","Huanuco","Margos","Pillcomarca","Quisqui","San Francisco de Cayran","San Pedro de Chaulan","Santa Maria del Valle","Yarumayo"};
    String[]Lauracocha={"Baqos","Jesus","Jivia","Queropalca","Rondos","San Francisco de Asis","San Miguel de Cauri",};
    String[]LeoncioPrado ={"Daniel Alomias Robles","Hermilio Valdizan","Jose Crespo y Castillo","Luyando","Mariano Damaso Beraun","Rupa-Rupa",};
    String[]Maraqon={"Cholon","Huacrachuco","San Buenaventura",};
    String[]Pachitea={"Chaglla","Molino","Panao","Umari",};
    String[]PuertoInca={"Codo del Pozuzo","Honoria","Puerto Inca","Tournavista","Yuyapichis",};
    String[]Yarowilca={"Cahuac","Chacabamba","Chavinillo","Choras","Chupan","Jacas Chico","Obas","Pampamarca",};

    //Ica
    String[]Chincha={"Alto Laran","Chavin","Chincha Alta","Chincha Baja","El Carmen","Grocio Prado"," Pueblo Nuevo","San Juan de Yanac"," San Pedro de Huacarpana","Sunampe","Tambo de Mora"};
    String[] ica={"Ica","La Tinguiqa","Los Aquijes","Ocucaje","Pachacutec","Parcona","Pueblo Nuevo","Salas","San Jose de los Molinos","San Juan Bautista","Santiago","Subtanjalla","Tate","Yauca del Rosario"};
    String[]Nazca={"Changuillo","El Ingenio","Marcona","Nazca","Vista Alegre"};
    String[]Palpa={"Llipata","Palpa","Rio Grande","Santa Cruz","Tibillo"};
    String[]Pisco={"Huancano","Humay","Independencia","Paracas","Pisco","San Andres","San Clemente","Tupac Amaru Inca"};

    //Junin
    String[] Chanchamayo={"Chanchamayo","Perene","Pichanaqui","San Luis de Shuaro","San Ramon","Vitoc"};
    String[]Chupaca={"Ahuac","Chongos Bajo","Chupaca","Huachac","Huamancaca Chico","San Juan de Iscos","San Juan de Jarpa","Tres de Diciembre","Yanacancha"};
    String[]Concepcion={"Aco","Andamarca","Chambara","Cochas","Comas","Concepcion","Heroinas Toledo","Manzanares","Mariscal Castilla","Matahuasi","Mito","Nueve de Julio","Orcotuna","San Jose de Quero","Santa Rosa de Ocopa"};
    String[]Huancayo ={"Carhuacallanga","Chacapampa","Chicche","Chilca","Chongos Alto","Chupuro","Colca","Cullhuas","El Tambo","Huacrapuquio","Hualhuas","Huancan","Huancayo","Huasicancha","Huayucachi","Ingenio","Pariahuanca","Pilcomayo","Pucara","Quichuay","Quilcas","San Agustin","San Jeronimo de Tunan","Santo Domingo de Acobamba","Sapallanga","Saqo","Sicaya","Viques"};
    String[]Jauja={"Acolla","Apata","Ataura","Canchayllo","Curicaca","El Mantaro","Huamali","Huaripampa","Huertas","Janjaillo","Jauja","Julcan","Leonor Ordoqez","Llocllapampa","Marco","Masma","Masma Chicche","Molinos","Monobamba","Muqui","Muquiyauyo","Paca","Paccha","Pancan","Parco","Pomacancha","Ricran","San Lorenzo","San Pedro de Chunan","Sausa","Sincos","Tunan Marca","Yauli","Yauyos",};
    String[]junin={"Carhuamayo","Junin","Ondores","Ulcumayo",};
    String[]Satipo={"Coviriali","Llaylla","Mazamari","Pampa Hermosa","Pangoa","Rio Negro","Rio Tambo","Satipo",};
    String[]Tarma={"Acobamba","Huaricolca","Huasahuasi","La Union","Palca","Palcamayo","San Pedro de Cajas","Tapo","Tarma",};
    String[]Yauli={"Chacapalpa","Huay-Huay","La Oroya","Marcapomacocha","Morococha","Paccha","Santa Barbara de Carhuacayan","Santa Rosa de Sacco","Suitucancha","Yauli",};

    //LaLibertad
    String[]Ascoqpe={"Asco qpe","Casa Grande"," Chicama","Chocope","Magdalena de Cao","Paijan","Razuri","Santiago de Cao",};
    String[] Bolivar={"Bambamarca","Bolivar","Condormarca","Longotea","Uchumarca","Ucuncha",};
    String[]Chepen={"Chepen"," Pacanga","Pueblo Nuevo",};
    String[]GranChimu={"Cascas","Lucma","Marmot","Sayapullo",};
    String[]Julcan={"Calamarca","Carabamba","Huaso","Julcan",};
    String[]Otuzco={"Agallpampa","Charat","Huaranchal","La Cuesta","Mache","Otuzco","Paranday","Salpo","Sinsicap","Usquil",};
    String[]Pacasmayo={"Guadalupe","Jequetepeque","Pacasmayo","San Jose","San Pedro de Lloc",};
    String[]Pataz={"Buldibuyo","Chillia","Huancaspata","Huaylillas","Huayo","Ongon","Parcoy","Pataz","Pias","Santiago de Challas","Taurija","Tayabamba","Urpay",};
    String[]SanchezCarrion={"Chugay","Cochorco","Curgos","Huamachuco","Marcabal","Sanagoran","Sarin","Sartimbamba",};
    String[]SantiagodeChuco = {"Angasmarca","Cachicadan","Mollebamba","Mollepata","Quiruvilca","Santa Cruz de Chuca","Santiago de Chuco","Sitabamba",};
    String[]Trujillo={"El Porvenir","Florencia de Mora","Huanchaco","La Esperanza","Laredo","Moche","Poroto","Salaverry","Simbal","Trujillo","Victor Larco Herrera",};
    String[]Viru={"Chao","Guadalupito","Viru",};

    //Lambayeque
    String[] Chiclayo={"Cayalti","Chiclayo","Chongoyape","Eten","Eten Puerto","Jose Leonardo Ortiz","La Victoria","Lagunas","Monsefu","Nueva Arica","Oyotun","Patapo","Picsi","Pimentel","Pomalca","Pucala","Reque","Santa Rosa","Saqa","Tuman","Zaña"};
    String[]Ferrenafe ={"Caqaris","Ferreqafe","Incahuasi","Manuel Antonio Mesones Muro","Pitipo","Pueblo Nuevo",};
    String[]lambayaque={"Chochope","Illimo","Jayanca","Lambayeque","Mochumi","Morrope","Motupe","Olmos","Pacora","Salas", "San Jose","Tucume"};

    //Lima
    String[]Barranca={"Barranca","Paramonga","Pativilca","Supe","Supe Puerto",};
    String[]Cajatambo={"Cajatambo","Copa","Gorgor","Huancapon","Manas",};
    String[]Callao={"Bellavista","Callao","Carmen de la Legua Reynoso","La Perla","La Punta","Ventanilla",};
    String[]Canete ={"Asia","Calango","Cerro Azul","Chilca","Coayllo","Imperial","Lunahuana","Mala","Nuevo Imperial","Pacaran","Quilmana","San Antonio","San Luis","San Vicente de Caquete","Santa Cruz de Flores","Zuqiga",};
    String[]Canta={"Arahuay","Canta","Huamantanga","Huaros","Lachaqui","San Buenaventura","Santa Rosa de Quives"};
    String[]Huaral={"Atavillos Alto","Atavillos Bajo","Aucallama","Chancay","Huaral","Ihuari","Lampian","Pacaraos","San Miguel de Acos","Santa Cruz de Andamarca","Sumbilca","Veintisiete de Noviembre",};
    String[]Huarochiri={"Antioquia","Callahuanca","Carampoma","Chicla","Cuenca","Huachupampa","Huanza","Huarochiri","Lahuaytambo","Langa","Laraos","Mariatana","Matucana","Ricardo Palma","San Andres de Tupicocha","San Antonio","San Bartolome","San Damian","San Juan de Iris","San Juan de Tantaranche","San Lorenzo de Quinti","San Mateo","San Mateo de Otao","San Pedro de Casta","San Pedro de Huancayre","Sangallaya","Santa Cruz de Cocachacra","Santa Eulalia","Santiago de Anchucaya","Santiago de Tuna","Santo Domingo de los Olleros","Surco"};
    String[]Huaura={"Ambar","Caleta de Carquin",	"Checras","Huacho","Hualmay","Huaura","Leoncio Prado","Paccho","Santa Leonor","Santa Maria","Sayan","Vegueta"};
    String[]lima={"Ancon","Ate","Barranco","Breña","Carabayllo","Cercado de Lima","Chaclacayo","Chorrillos","Cieneguilla ","Comas","El Agustino","Independencia","Jesus Maria","La Molina","La Victoria","Lince","Los Olivos","Lurigancho","Lurin","Magdalena del Mar","Miraflores","Pachacamac","Pucusana","Pueblo Libre","Puente Piedra","Punta Hermosa","Punta Negra","Rimac","San Bartolo","San Borja","San Isidro","San Juan de Lurigancho","San Juan de Miraflores","San Luis","San Martin de Porres","San Miguel, Lima","Santa Anita","Santa Maria del Mar","Santa Rosa","Santiago de Surco","Surquillo","Villa El Salvador","Villa Maria del Triunfo"};
    String[]Oyon={"Andajes","Caujul","Cochamarca","Navan","Oyon","Pachangara",};
    String[]Yauyos={"Alis","Ayauca","Ayaviri","Azangaro","Cacra","Carania","Catahuasi","Chocos","Cochas","Colonia","Hongos","Huampara","Huancaya","Huangascar","Huantan","Huaqec","Laraos","Lincha","Madean","Miraflores","Omas","Putinza","Quinches","Quinocay","San Joaquin","San Pedro de Pilas","Tanta","Tauripampa","Tomas","Tupe","Viqac","Vitis","Yauyos"};

    //Loreto

    String[]AltoAmazonas={"Balsapuerto","Barranca","Cahuapanas","Jeberos","Lagunas","Manseriche","Morona","Pastaza","Santa Cruz","Teniente Cesar Lopez Rojas","Yurimaguas",};
    String[]loreto={"Nauta","Parinari","Tigre","Trompeteros","Urarinas",};
    String[]MariscalRamonCastilla={"Pebas","Ramon Castilla","San Pablo","Yavari",};
    String[]Maynas={"Alto Nanay","Belen","Fernando Lores","Indiana","Iquitos","Las Amazonas","Mazan","Napo","Punchana","Putumayo","San Juan Bautista","Torres Causana","Yaquerana"};
    String[]Requena={"Alto Tapiche","Capelo","Emilio San Martin","Jenaro Herrera","Maquia","Puinahua","Requena","Saquena","Soplin","Tapiche","Yaquerana",};
    String[]ucayali={"Contamana","Inahuaya","Padre Marquez","Pampa Hermosa","Sarayacu","Vargas Guerra",};

    //MadredeDios
    String[]Manu={"Fitzcarrald","Huepetuhe","Madre de Dios","Manu",};
    String[]Tahuamanu={"Iberia","Iqapari","Tahuamanu"};
    String[]Tambopata={"Inambari","Laberinto","Las Piedras","Tambopata"};

    //Moquegua
    String[]GeneralSanchezCerro ={"Chojata","Coalaque","Ichuqa","La Capilla","Lloque","Matalaque","Omate","Puquina","Quinistaquillas","Ubinas","Yunga"};
    String[]Ilo={"El Algarrobal","Ilo","Pacocha",};
    String[] MariscalNieto={"Carumas","Cuchumbaya","Moquegua","Samegua","San Cristobal","Torata",};
    String[] DanielAlcidesCarrion={"Chacayan","Goyllarisquizga","Paucar","San Pedro de Pillao","Santa Ana de Tusi","Tapuc","Vilcabamba","Yanahuanca",};

    //Pasco
    String[]Oxapampa={"Chontabamba","Huancabamba","Oxapampa","Palcazu","Pozuzo","Puerto Bermudez","Villa Rica",};
    String[]pasco={"Chaupimarca","Huachon","Huariaca","Huayllay","Ninacaca","Pallanchacra","Paucartambo","San Fco.De Asis de Yarusyacan","Simon Bolivar","Ticlacayan","Tinyahuarco","Vicco","Yanacancha",};

    //Piura
    String[]Ayabaca={"Ayabaca","Frias","Jilili","Lagunas","Montero","Pacaipampa","Paimas","Sapillica","Sicchez","Suyo",};
    String[]Huancabamba ={"Canchaque","El Carmen de la Frontera","Huancabamba","Huarmaca","Lalaquiz","San Miguel de El Faique","Sondor","Sondorillo"};
    String[] Morropon={"Buenos Aires","Chalaco","Chulucanas","La Matanza","Morropon","Salitral","San Juan de Bigote","Santa Catalina de Mossa","Santo Domingo","Yamango"};
    String[]Paita={"Amotape","Arenal","Colan","La Huaca","Paita","Tamarindo","Vichayal"};
    String[]piura={"Castilla","Catacaos","Cura Mori","El Tallan","La Arena","La Union","Las Lomas","Piura","Tambo Grande",};
    String[]Sechura={"Bellavista de la Union","Bernal","Cristo Nos Valga","Rinconada Llicuar","Sechura","Vice",};
    String[]Sullana={"Bellavista","Ignacio Escudero","Lancones","Marcavelica","Miguel Checa","Querecotillo","Salitral","Sullana",};
    String[]Talara={"El Alto","La Brea","Lobitos","Los Organos","Mancora","Pariqas","Achaya",};

    //Puno

    String[]Azangaro={"Arapa","Asillo","Azangaro","Caminaca","Chupa","Jose Domingo Choquehuanca","Muqani","Potoni","Saman","San Anton","San Jose","San Juan de Salinas","Santiago de Pupuja","Tirapata"};
    String[]Carabaya={"Ajoyani","Ayapata","Coasa","Corani","Crucero","Ituata","Macusani","Ollachea","San Gaban","Usicayos"};
    String[]Chucuito={"Desaguadero","Huacullani","Juli","Kelluyo","Pisacoma","Pomata","Zepita",};
    String[]ElCollao={"Capazo","Conduriri","Ilave","Pilcuyo","Santa Rosa",};
    String[]Huancane={"Cojata","Huancane","Huatasani","Inchupalla","Pusi","Rosaspata","Taraco","Vilque Chico"};
    String[]Lampa={"Cabanilla","Calapuja","Lampa","Nicasio","Ocuviri","Palca","Paratia","Pucara","Santa Lucia","Vilavila"};
    String[]Melgar={"Antauta","Ayaviri","Cupi","Llalli","Macari","Nuqoa","Orurillo","Santa Rosa","Umachiri",};
    String[]Moho={"Conima","Huayrapata","Moho","Tilali"};
    String[]puno={"Acora","Amantani","Atuncolla","Capachica","Chucuito","Coata","Huata","Maqazo","Paucarcolla","Pichacani","Plateria","Puno","San Antonio","Tiquillaca","Vilque",};
    String[]SanAntoniodePutina ={"Ananea","Pedro Vilca Apaza","Putina","Quilcapuncu","Sina",};
    String[]SanRoman={"Cabana","Cabanillas","Caracoto","Juliaca",};
    String[]Sandia={"Alto Inambari","Cuyocuyo","Limbani","Patambuco","Phara","Quiaca","San Juan del Oro","Sandia","Yanahuaya"};
    String[]Yunguyo={"Anapia","Copani","Cuturapi","Ollaraya","Tinicachi","Unicachi","Yunguyo",};

    //SanMartin
    String[]Bellavista ={"Alto Biavo","Bajo Biavo","Bellavista","Huallaga","San Pablo","San Rafael",};
    String[]ElDorado={"Agua Blanca","San Jose de Sisa","San Martin","Santa Rosa","Shatoja"};
    String[]Huallaga ={"Alto Saposoa","El Eslabon","Piscoyacu","Sacanche","Saposoa","Tingo de Saposoa",};
    String[]Lamas={"Alonso de Alvarado","Barranquita","Caynarachi"," Cuqumbuqui","Lamas","Pinto Recodo","Rumisapa","San Roque de Cumbaza","Shanao","Tabalosos","Zapatero",};
    String[]MariscalCaceres ={"Campanilla","Huicungo","Juanjui","Pachiza","Pajarillo"};
    String[] Moyobamba ={"Calzada","Habana","Jepelacio","Moyobamba","Soritor","Yantalo"};
    String[]Picota ={"Buenos Aires","Caspisapa","Picota","Pilluana","Pucacaca","San Cristobal","San Hilarion","Shamboyacu","Tingo de Ponasa","Tres Unidos",};
    String[]Rioja={"Awajun","Elias Soplin Vargas","Nueva Cajamarca","Pardo Miguel","Posic","Rioja","San Fernando","Yorongos","Yuracyacu"};
    String[]Sanmartin ={"Alberto Leveau","Cacatachi","Chazuta"," Chipurana","El Porvenir","Huimbayoc","Juan Guerra","La Banda de Shilcayo","Morales","Papaplaya","San Antonio","Sauce","Shapaja","Tarapoto"};
    String[]Tocache={"Nuevo Progreso","Polvora","Shunte", "Tocache","Uchiza"};

    //Tacna
    String[]Candarave ={"Cairani","Camilaca","Candarave","Curibaya","Huanuara","Quilahuani",};
    String[]JorgeBasadre={"Ilabaya","Ite","Locumba",};
    String[]tacna={"Alto de la Alianza","Calana","Ciudad Nueva","Cor Gregorio Albarracin","Inclan", "Pachia","Palca","Pocollay","Sama","Tacna",};
    String[]Tarata ={"Chucatamani","Estique","Estique-Pampa","Sitajara","Susapaya","Tarata","Tarucachi"," Ticaco",};

    //Tumbes
    String[] ContralmiranteVillar ={"Casitas","Zorritos"};
    String[] tumbes={"Corrales","La Cruz","Pampas de Hospital","San Jacinto","San Juan de la Virgen","Tumbes"};
    String[]Zarumilla={"Aguas Verdes","Matapalo","Papayal","Zarumilla"};

    //Ucayali
    String[]Atalaya={"Raymondi","Sepahua","Tahuania","Yurua",};
    String[]CoronelPortillo ={"Calleria","Campoverde","Iparia","Masisea","Nueva Requena","Yarinacocha",};
    String[]PadreAbad={"Curimana","Irazola","Padre Abad",};
    String[]Purus ={"Purus"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_crear);

        findElemente();
        event();
        ubigeo = new ArrayList<String[]>();
        ubigeo.add(Amazonas);
        ubigeo.add(Ancash);
        ubigeo.add(Apurimac);
        ubigeo.add(Arequipa);
        ubigeo.add(Ayacucho);
        ubigeo.add(Cajamarca);
        ubigeo.add(Cusco);
        ubigeo.add(Huancavelica);
        ubigeo.add(Huanuco);
        ubigeo.add(Ica);
        ubigeo.add(Junin);
        ubigeo.add(LaLibertad);
        ubigeo.add(Lambayeque);
        ubigeo.add(Lima);
        ubigeo.add(Loreto);
        ubigeo.add(MadredeDios);
        ubigeo.add(Moquegua);
        ubigeo.add(Pasco);
        ubigeo.add(Piura);
        ubigeo.add(Puno);
        ubigeo.add(SanMartin);
        ubigeo.add(Tacna);
        ubigeo.add(Tumbes);
        ubigeo.add(Ucayali);

        ubigeoDistrito = new ArrayList<List<String[]>>();
        ArrayList amazonas = new ArrayList<String[]>();
        amazonas.add(Bagua);
        amazonas.add(Bongara);
        amazonas.add(Chachapoyas);
        amazonas.add(Condorcanqui);
        amazonas.add(Luya);
        amazonas.add(RodriguezdeMendoza);
        amazonas.add(Utcubamba);
        ubigeoDistrito.add(amazonas);

        ubigeoDistrito = new ArrayList<List<String[]>>();
        ArrayList ancash = new ArrayList<String[]>();
        ancash.add(Aija);
        ancash.add(AntonioRaymondi);
        ancash.add(Asuncion);
        ancash.add(Bolognesi);
        ancash.add(Carhuaz);
        ancash.add(CarlosFerminFitzcarrald);
        ancash.add(Casma);
        ancash.add(Corongo);
        ancash.add(Casma);
        ancash.add(Huaraz);
        ancash.add(Huari);
        ancash.add(Huarmey);
        ancash.add(Huaylas);
        ancash.add(MariscalLuzuriaga);
        ancash.add(Ocros);
        ancash.add(Huarmey);
        ancash.add(Pallasca);
        ancash.add(Pomabamba);
        ancash.add(Recuay);
        ancash.add(Santa);
        ancash.add(Sihuas);
        ancash.add(Yungay);
        ubigeoDistrito.add(ancash);

        ubigeoDistrito = new ArrayList<List<String[]>>();
        ArrayList apurimac = new ArrayList<String[]>();
        apurimac.add(Abancay);
        apurimac.add(Andahuaylas);
        apurimac.add(Antabamba);
        apurimac.add(Aymaraes);
        apurimac.add(Chincheros);
        apurimac.add(Cotabambas);
        apurimac.add(Grau);
        ubigeoDistrito.add(apurimac);

        ArrayList aarequipa = new ArrayList<String[]>();
        aarequipa.add(arequipa);
        aarequipa.add(Camana);
        aarequipa.add(Caraveli);
        aarequipa.add(Castilla);
        aarequipa.add(Caylloma);
        aarequipa.add(Condesuyos);
        aarequipa.add(Islay);
        aarequipa.add(LaUnion);
        ubigeoDistrito.add(aarequipa);

        ArrayList ayacucho = new ArrayList<String[]>();
        ayacucho.add(Cangallo);
        ayacucho.add(Huamanga);
        ayacucho.add(HuancaSancos);
        ayacucho.add(Huanta);
        ayacucho.add(LaMar);
        ayacucho.add(Lucanas);
        ayacucho.add(Parinacocha);
        ayacucho.add(PaucardelSaraSara);
        ayacucho.add(Sucre);
        ayacucho.add(VictorFajardo);
        ayacucho.add(VilcasHuaman);
        ubigeoDistrito.add(ayacucho);

        ArrayList cajamarcaa = new ArrayList<String[]>();
        cajamarcaa.add(Cajabamba);
        cajamarcaa.add(cajamarca);
        cajamarcaa.add(Celendin);
        cajamarcaa.add(Chota);
        cajamarcaa.add(Contumaza);
        cajamarcaa.add(Cutervo);
        cajamarcaa.add(Hualgayoc);
        cajamarcaa.add(Jaen);
        cajamarcaa.add(SanIgnacio);
        cajamarcaa.add(SanMarcos);
        cajamarcaa.add(SanMiguel);
        cajamarcaa.add(SanPablo);
        cajamarcaa.add(SantaCruz);
        ubigeoDistrito.add(cajamarcaa);

        ArrayList cusco = new ArrayList<String[]>();
        cusco.add(Acomayo);
        cusco.add(Anta);
        cusco.add(Calca);
        cusco.add(Canas);
        cusco.add(Canchis);
        cusco.add(Chumbivilcas);
        cusco.add(Cusco);
        cusco.add(Espinar);
        cusco.add(LaConvencion);
        cusco.add(Paruro);
        cusco.add(Paucartambo);
        cusco.add(Quispicanchi);
        cusco.add(Urubamba);
        ubigeoDistrito.add(cusco);

        ArrayList huancavelicaa = new ArrayList<String[]>();
        huancavelicaa.add(Acobamba);
        huancavelicaa.add(Angaraes);
        huancavelicaa.add(Castrovirreyna);
        huancavelicaa.add(Churcampa);
        huancavelicaa.add(huancavelica);
        huancavelicaa.add(Huaytara);
        huancavelicaa.add(Tayacaja);
        ubigeoDistrito.add(huancavelicaa);

        ArrayList huanucoo = new ArrayList<String[]>();
        huanucoo.add(Ambo);
        huanucoo.add(DosdeMayo);
        huanucoo.add(Huacaybamba);
        huanucoo.add(Huamalies);
        huanucoo.add(huanuco);
        huanucoo.add(Lauracocha);
        huanucoo.add(LeoncioPrado);
        huanucoo.add(Maraqon);
        huanucoo.add(Pachitea);
        huanucoo.add(PuertoInca);
        huanucoo.add(Yarowilca);
        ubigeoDistrito.add(huanucoo);

        ArrayList icaa = new ArrayList<String[]>();
        icaa.add(Chincha);
        icaa.add(ica);
        icaa.add(Nazca);
        icaa.add(Palpa);
        icaa.add(Pisco);
        ubigeoDistrito.add(icaa);

        ArrayList juninn = new ArrayList<String[]>();
        juninn.add(Chanchamayo);
        juninn.add(Chupaca);
        juninn.add(Concepcion);
        juninn.add(Huancayo);
        juninn.add(Jauja);
        juninn.add(junin);
        juninn.add(Satipo);
        juninn.add(Tarma);
        juninn.add(Yauli);
        ubigeoDistrito.add(juninn);

        ArrayList lalibertad = new ArrayList<String[]>();
        lalibertad.add(Ascoqpe);
        lalibertad.add(Bolivar);
        lalibertad.add(Chepen);
        lalibertad.add(GranChimu);
        lalibertad.add(Julcan);
        lalibertad.add(Otuzco);
        lalibertad.add(Pacasmayo);
        lalibertad.add(Pataz);
        lalibertad.add(SanchezCarrion);
        lalibertad.add(SantiagodeChuco);
        lalibertad.add(Trujillo);
        lalibertad.add(Viru);
        ubigeoDistrito.add(lalibertad);

        ArrayList lambayequee = new ArrayList<String[]>();
        lambayequee.add(Chiclayo);
        lambayequee.add(Ferrenafe);
        lambayequee.add(lambayaque);
        ubigeoDistrito.add(lambayequee);

        ArrayList limaa = new ArrayList<String[]>();
        limaa.add(Barranca);
        limaa.add(Cajatambo);
        limaa.add(Callao);
        limaa.add(Canta);
        limaa.add(Canete);
        limaa.add(Huaral);
        limaa.add(Huarochiri);
        limaa.add(Huaura);
        limaa.add(lima);
        limaa.add(Oyon);
        limaa.add(Yauyos);

        ubigeoDistrito.add(limaa);

        ArrayList loretoo = new ArrayList<String[]>();
        loretoo.add(AltoAmazonas);
        loretoo.add(loreto);
        loretoo.add(MariscalRamonCastilla);
        loretoo.add(Maynas);
        loretoo.add(Requena);
        loretoo.add(ucayali);
        ubigeoDistrito.add(loretoo);

        ArrayList madrededios = new ArrayList<String[]>();
        madrededios.add(Manu);
        madrededios.add(Tahuamanu);
        madrededios.add(Tambopata);
        ubigeoDistrito.add(madrededios);

        ArrayList moquegua = new ArrayList<String[]>();
        moquegua.add(GeneralSanchezCerro);
        moquegua.add(Ilo);
        moquegua.add(MariscalNieto);
        moquegua.add(DanielAlcidesCarrion);
        ubigeoDistrito.add(moquegua);

        ArrayList pascoo = new ArrayList<String[]>();
        pascoo.add(Oxapampa);
        pascoo.add(pasco);
        ubigeoDistrito.add(pascoo);

        ArrayList piuraa = new ArrayList<String[]>();
        piuraa.add(Ayabaca);
        piuraa.add(Huancabamba);
        piuraa.add(Morropon);
        piuraa.add(Paita);
        piuraa.add(piura);
        piuraa.add(Sechura);
        piuraa.add(Sullana);
        piuraa.add(Talara);
        ubigeoDistrito.add(piuraa);

        ArrayList punoo = new ArrayList<String[]>();
        punoo.add(Azangaro);
        punoo.add(Carabaya);
        punoo.add(Chucuito);
        punoo.add(ElCollao);
        punoo.add(Huancane);
        punoo.add(Lampa);
        punoo.add(Melgar);
        punoo.add(Moho);
        punoo.add(puno);
        punoo.add(SanAntoniodePutina);
        punoo.add(SanRoman);
        punoo.add(Sandia);
        punoo.add(Yunguyo);
        ubigeoDistrito.add(punoo);

        ArrayList sanmartin = new ArrayList<String[]>();
        sanmartin.add(Bellavista);
        sanmartin.add(ElDorado);
        sanmartin.add(Huallaga);
        sanmartin.add(Lamas);
        sanmartin.add(MariscalCaceres);
        sanmartin.add(Moyobamba);
        sanmartin.add(Picota);
        sanmartin.add(Rioja);
        sanmartin.add(Sanmartin);
        sanmartin.add(Tocache);
        ubigeoDistrito.add(sanmartin);

        ArrayList tacnaa = new ArrayList<String[]>();
        tacnaa.add(Candarave);
        tacnaa.add(JorgeBasadre);
        tacnaa.add(tacna);
        tacnaa.add(Tarata);
        ubigeoDistrito.add(tacnaa);

        ArrayList tumbess = new ArrayList<String[]>();
        tumbess.add(ContralmiranteVillar);
        tumbess.add(tumbes);
        tumbess.add(Zarumilla);
        ubigeoDistrito.add(tumbess);

        ArrayList ucayali = new ArrayList<String[]>();
        ucayali.add(Atalaya);
        ucayali.add(CoronelPortillo);
        ucayali.add(PadreAbad);
        ucayali.add(Purus);
        ubigeoDistrito.add(ucayali);
    }

    private void findElemente() {
        regresar = findViewById(R.id.regresarPerfilEditar);
        nombreCabecera = findViewById(R.id.perfilUsuarioNombreEditar);
        btnSave = findViewById(R.id.btnSave);
        nombre = findViewById(R.id.Nombre);
        apellido=findViewById(R.id.Apellido);
        Email=findViewById(R.id.Email);
        Telefono=findViewById(R.id.Telefono);
        Contrasena=findViewById(R.id.contrasena);
        RepeteContrasena=findViewById(R.id.contrasena2);
        rb=findViewById(R.id.radio_masculino);

        //Aqui arranca y carga los departamentos
        departamento=(Spinner)findViewById(R.id.departamento);
        provincia = (Spinner)findViewById(R.id.provincia);
        distrito = (Spinner)findViewById(R.id.distrito);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_spinner_item,datosdepartamento);
        departamento.setAdapter(adaptador);


        //Aqui Arranca Provincia
        departamento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                int index = adapterView.getSelectedItemPosition();

                provincia=(Spinner)findViewById(R.id.provincia);
                provinciaSeleccionada = index;
                ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_spinner_item,ubigeo.get(index));
                provincia.setAdapter(adaptador);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Distrito
        provincia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int index = adapterView.getSelectedItemPosition();

                distrito=(Spinner)findViewById(R.id.distrito);

                ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_spinner_item,ubigeoDistrito.get(provinciaSeleccionada).get(index));
                distrito.setAdapter(adaptador);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Is the button now checked?
                boolean checked = ((RadioButton) view).isChecked();

                // Check which radio button was clicked
                switch(view.getId()) {
                    case R.id.radio_femenino:
                        if (checked)
                            sexo="F";
                        Toast toast1 = Toast.makeText(getApplicationContext(), "Femenino", Toast.LENGTH_SHORT);
                        break;
                    case R.id.radio_masculino:
                        if (checked)
                            sexo="M";
                        Toast toast2 = Toast.makeText(getApplicationContext(), "Masculino", Toast.LENGTH_SHORT);
                        break;
                }

            }
        });


        btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (Contrasena.getText().toString().trim().isEmpty()) {
                    Contrasena.setError("Llenar Campo Faltante");
                } else {
                    //Here you can write the codes for checking password
                }
                if (RepeteContrasena.getText().toString().trim().isEmpty()) {
                    RepeteContrasena.setError("Llenar Campo Faltante");
                } else {
                    if(RepeteContrasena.getText().toString().equals(Contrasena.getText().toString())){

                    }else{
                        RepeteContrasena.setError("Error en contraseña");
                    }
                }
                if (nombre.getText().toString().trim().isEmpty()) {

                    nombre.setError("Llenar Campo Faltante");
                } else {

                }
                if (apellido.getText().toString().trim().isEmpty()) {

                    apellido.setError("Llenar Campo Faltante");
                } else {

                }
                if (Email.getText().toString().trim().isEmpty()) {

                    Email.setError("Llenar Campo Faltante");
                } else {

                }
                if (Telefono.getText().toString().trim().isEmpty()) {
                    Telefono.setError("Llenar Campo Faltante");
                } else {

                }



                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(ServicioUsuario.ip)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ServicioUsuario servicioUsuario = retrofit.create(ServicioUsuario.class);
                Call<Usuario> usr  = servicioUsuario.CrearUsuario(Email.getText().toString(),nombre.getText().toString(),apellido.getText().toString(),"slgslg@gmail.com",Contrasena.getText().toString(),"M",Telefono.getText().toString());
                usr.enqueue(new Callback<Usuario>() {
                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                        if(response.code() == 201){
                            Usuario u = response.body();
                            Toast.makeText(getApplicationContext(), u.token, Toast.LENGTH_SHORT).show();
                            setContentView(R.layout.activity_home);
                            SharedPreferences prefs =
                                    getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

                            SharedPreferences.Editor editor = prefs.edit();
                            // Guardar el codigo del usuario
                            //editor.putString("id", );
                            editor.putString("email_usuario", "modificado@email.com");
                            editor.commit();
                        }else{
                            Toast.makeText(getApplicationContext(), response.code()+"" , Toast.LENGTH_SHORT).show();
                        }
                    }


                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),t.toString() , Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    private void event() {
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regresarPerfil = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(regresarPerfil);
            }
        });

        nombreCabecera.setText("Crear Usuario");
    }
}
