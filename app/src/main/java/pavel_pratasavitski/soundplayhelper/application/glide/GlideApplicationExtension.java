package pavel_pratasavitski.soundplayhelper.application.glide;

import com.bumptech.glide.Priority;
import com.bumptech.glide.annotation.GlideExtension;
import com.bumptech.glide.annotation.GlideOption;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import pavel_pratasavitski.soundplayhelper.R;

@GlideExtension
public class GlideApplicationExtension {

    private GlideApplicationExtension() {
    }

    @GlideOption
    public static void defaultOptions(final RequestOptions options) {
        options
                .placeholder(R.color.color_dark_background)
                .fallback(R.color.color_dark_background)
                .error(R.color.color_dark_background)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .priority(Priority.HIGH);
    }
}
