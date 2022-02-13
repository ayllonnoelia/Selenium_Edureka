package ejercicio;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

public class Edureka {

	public static void main(String[] args) {
		
		//Declaro las variables
		String rutaDriver= "drivers/chromedriver.exe";
		String urlAcceso = "https://www.edureka.co/";
		
		//Invoco ChromeDriver y creo el Driver Object
		System.setProperty("webdriver.chrome.driver", rutaDriver);
		WebDriver driver = new ChromeDriver();
		
		//Pongo unos segundos de espera para que si hay algo que no se está mostrando debido a la 
		//velocidad de ejecución, espere x segundos antes de lanzar un error.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Accedo a la url
		driver.get(urlAcceso);

		//Pongo la ventana a tamaño completo
		driver.manage().window().maximize();
		
		try {
			
			/********************************************
			 * 
			 * PASO 1. INICIAR SESIÓN.
			 * 
			 * SE OBTIENEN LOS ELEMENTOS A TRAVÉS DE XPATH
			 * 
			 */
			
			//Encuentro el botón Log In
			driver.findElement(By.xpath("//span[@class='login_click login-vd giTrackElementHeader ']")).click();
			
			//Introduzco el correo temporal
			driver.findElement(By.xpath("//input[@id='si_popup_email']")).sendKeys("fcorwinq_j82w@tigpe.com");
			
			//Introduzco la contraseña
			driver.findElement(By.xpath("//input[@id='si_popup_passwd']")).sendKeys("A12345678a");
			
			//Pulso el botón
			driver.findElement(By.xpath("//button[@class='clik_btn_log btn-block']")).click();
			
			
			/********************************************
			 * 
			 * PASO 2. NAVEGAR A 'MI PERFIL'.
			 * 
			 * EL PRIMER ELEMENTO SE OBTIENE CON CSS SELECTOR Y EL SEGUNDO CON LINK TEXT
			 * 
			 */
			
			//pulso en el icono de perfil
			driver.findElement(By.cssSelector("img.img30")).click();
			
			//selecciono la opción 'My Profile'
			driver.findElement(By.linkText("My Profile")).click();
			
			
			/********************************************
			 * 
			 * PASO 3. ACTUALIZAR DATOS PROFESIONALES Y PERSONALES.
			 * 
			 */
			
			//Pulso en el lápiz de User Details
			driver.findElement(By.xpath("//i[@class='icon-pr-edit']")).click();
			
					
			//Limpio el input, pongo un tiempo de espera e introduzco el nombre
			driver.findElement(By.xpath("//input[@id='fullName']")).clear();
			Thread.sleep(1500);
			driver.findElement(By.xpath("//input[@id='fullName']")).sendKeys("Noelia");
			
			//utilizo indexes (no es lo más recomendado) para localizar los botones entre todos los 
			//elementos encontrados en la busqueda.
			//elimino los espacios innecesarios de las opciones existentes en los desplegables
			driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();

			if (driver.findElement(By.xpath("(//button[@type='button'])[5]")) == driver.findElement(By.xpath("//li[normalize-space()='2-4 years']"))) {
				
				driver.findElement(By.xpath("//li[normalize-space()='0-2 years']")).click();
				
			}else if (driver.findElement(By.xpath("(//button[@type='button'])[5]")) == driver.findElement(By.xpath("//li[normalize-space()='0-2 years']"))) {
				
				driver.findElement(By.xpath("//li[normalize-space()='2-4 years']")).click();
			}
			
			driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
			
			if (driver.findElement(By.xpath("(//button[@type='button'])[6]")) == driver.findElement(By.xpath("//li[normalize-space()='IT-Hardware & Networking']"))) {
				
				driver.findElement(By.xpath("//li[normalize-space()='IT-Software / Software Services']")).click();
				
			} else if (driver.findElement(By.xpath("(//button[@type='button'])[6]")) == driver.findElement(By.xpath("//li[normalize-space()='IT-Software / Software Services']"))){

				driver.findElement(By.xpath("//li[normalize-space()='IT-Hardware & Networking']")).click();
				
			}			

			driver.findElement(By.xpath("//input[@id='designation']")).clear();
			driver.findElement(By.xpath("//input[@id='designation']")).sendKeys("Tester");
			
			//pulso el botón
			driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg btn-save btn_save pull-right']")).click();
			Thread.sleep(3000);
			
			//pulso en la sección 'Carrer Services'
			driver.findElement(By.linkText("Career Services")).click();
			Thread.sleep(3000);
			//Pulso en el lápiz de 'Professional Details'. Me veo obligada a utilizar index para identificar
			//que elemento es entre varios
			driver.findElement(By.xpath("(//i[@class='icon-pr-edit'])[1]")).click();
			Thread.sleep(3000);
			
			//Introduzco un literal en el input de nombre de compañia
			driver.findElement(By.xpath("//input[@name='companyName']")).clear();
			driver.findElement(By.xpath("//input[@name='companyName']")).sendKeys("Capgemini Engineering");
			
			//Pulso en el desplegable y selecciono una opción del desplegable
			driver.findElement(By.xpath("//select[@name='currentjob']")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("//option[@value='Entry Level']")).click();
			
			//Introduzco habilidades
			driver.findElement(By.xpath("//input[@name='userSkill']")).clear();
			driver.findElement(By.xpath("//input[@name='userSkill']")).sendKeys("Proactiva, constante, sociable");
			Thread.sleep(5000);
			//Pulso en el botón 'Next'
			driver.findElement(By.xpath("//button[@class='btn pull-right onboarding-primary-button']")).click();
			Thread.sleep(5000);
			//Pulso en los desplegables y selecciono una opción de todos
			driver.findElement(By.xpath("//select[@name='interestedJob']")).click();
			driver.findElement(By.xpath("//option[@value='Software Testing']")).click();
			
			driver.findElement(By.xpath("//select[@name='elementType']")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("//option[@value='Contract']")).click();
			
			//Introduzco donde vivo
			driver.findElement(By.xpath("//input[@name='currentCity']")).clear();
			driver.findElement(By.xpath("//input[@name='currentCity']")).sendKeys("Madrid");
			
			//Pulso en el desplegable de salario y selecciono una opcion
			driver.findElement(By.xpath("//select[@name='lastDrawnSalaryUS']")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("//option[@value='$25K - $50K']")).click();
			
			//clico el checkbox (radio)
			driver.findElement(By.xpath("//span[@class='checkmark']")).click();
			
			//introduzco la localizacion preferida
			driver.findElement(By.xpath("//input[@name='preferredCity']")).clear();
			driver.findElement(By.xpath("//input[@name='preferredCity']")).sendKeys("Madrid");
			
			Thread.sleep(5000);
			//Pulso en el botón 'Next'
			driver.findElement(By.xpath("//button[@class='btn onboarding-primary-button pull-right']")).click();
			Thread.sleep(5000);
			
			//Pulso en el botón 'Save'
			driver.findElement(By.xpath("//button[@class='btn pull-right onboarding-primary-button']")).click();
			Thread.sleep(1500);
			
			/********************************************
			 * 
			 * PASO 4. EXPLORA LOS BLOGS Y NAVEGUE HASTA LA PAGINA PRINCIPAL
			 * 
			 */
			
			//pulso en la sección 'Topics of Interest' (blogs) 
			driver.findElement(By.linkText("Topics of Interest")).click();
			
			Thread.sleep(1500);
			
			//redirijo a la Home
			driver.findElement(By.linkText("Home")).click();
			
			
			/********************************************
			 * 
			 * PASO 5. CERRAR SESIÓN DEL PORTAL
			 * 
			 */
			
			//pulso en el icono de perfil
			driver.findElement(By.cssSelector("img.img30")).click();
			
			//selecciono la opción 'Log Out'
			driver.findElement(By.linkText("Log Out")).click();

			
		} catch (NoSuchElementException ne) {
			System.out.println("Elemento no encontrado: " + ne.getMessage());
		} catch (WebDriverException we) {
			System.out.println("Webdriver falló: " + we.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			//utilizo quit() pero podría utilizar close() ya que este programa solo
			//abre una ventana
			driver.quit();
		}
		
	}

}
