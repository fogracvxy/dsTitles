package denniss17.dsTitle.Placeholders;

import org.bukkit.entity.Player;

import com.kaltiz.dsTitle.TitleManager;

import denniss17.dsTitle.DSTitle;
import me.clip.deluxechat.placeholders.DeluxePlaceholderHook;
import me.clip.deluxechat.placeholders.PlaceholderHandler;

public class DeluxeChatHook
{

/**
	 * Registers Placeholders into DeluxeChat for dsTitle Suffixes/Prefixes
	 * Use these in DeluxeChat by using %dsTitle_prefix% for prefix or %dsTitle_suffix% for suffix
	 * @return True if placeholders were registered successfully, false if failed
	 */
	public static boolean RegisterDeluxeChatHooks(final DSTitle plugin){
		boolean hookedchat = PlaceholderHandler.registerPlaceholderHook(plugin, new DeluxePlaceholderHook(){
			public String onPlaceholderRequest(Player p, String identifier) {
                if(identifier.equals("prefix")){
                	TitleManager man = plugin.getTitleManager();
                    if (man != null)
                    {
                  	String prefixTag;
                  	prefixTag = man.getPrefixChatTag(p);
                      if (prefixTag != null)
                      {
                        return man.getPrefixChatTag(p);
                      }else
                      {
                        return " ";
                      }
                    }else
                    {
                      return " ";
                    }
				}
                if(identifier.equals("suffix")){
                	TitleManager man = plugin.getTitleManager();
                    if (man != null)
                    {
                  	String suffixTag;
                  	suffixTag = man.getSuffixChatTag(p);
                      if (suffixTag != null)
                      {
                        return man.getSuffixChatTag(p);
                      }else
                      {
                        return " ";
                      }
                    }else
                    {
                      return " ";
                    }
				}
				return null;
			}
			
		});
		return hookedchat;
	}
}