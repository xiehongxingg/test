package System.out;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.arangodb.ArangoCursor;
import com.arangodb.ArangoDB;
import com.arangodb.ArangoDatabase;
import com.arangodb.entity.BaseDocument;
import com.arangodb.model.AqlQueryOptions;

public class ArangoTest {
	
	@Test
	public void findrole() throws Exception {
		try {
			ArangoDB arango = new ArangoDB.Builder().host("127.0.0.1", 8529)
					.user("root").build();
			ArangoDatabase mydb = arango.db("myAQL");

			String queryCmmd = "for doc in @@collection return  doc";
			AqlQueryOptions options = new AqlQueryOptions();
			options.ttl(1000000);// 持续时间
			Map map = new HashMap();
			map.put("@collection", "test");
			ArangoCursor<BaseDocument> cursor = mydb.query(queryCmmd, map,
					options, BaseDocument.class);
			int ii = 0;
			while (cursor.hasNext()) {
				ii++;
				BaseDocument object = cursor.next();
				// String name =object.getAttribute("name").toString(); //输出
				System.out.println(object.toString());
				System.out.println(ii);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
