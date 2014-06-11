package ctd.net.broadcast;

import java.io.Serializable;

public interface Observer {
	void onMessage(Serializable... arg);
}
