import java.io.IOException;
import java.sql.SQLException;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

/**
 * This class creates a config file for reflection hacks
 * to make loading not take forever on Android.
 * 
 * WHENEVER YOU EDIT A DB CONFIG ANNOTATION, RUN THIS ON YOUR DEV BOX!!!!!
 * @author Martin Wickham
 *
 */
public class DatabaseConfigUtil extends OrmLiteConfigUtil {
	public static void main(String[] args) throws SQLException, IOException {
		writeConfigFile("ormlite_config.txt");
	}
}
