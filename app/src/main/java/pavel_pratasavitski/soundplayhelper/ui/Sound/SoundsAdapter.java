package pavel_pratasavitski.soundplayhelper.ui.Sound;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pavel_pratasavitski.soundplayhelper.R;
import pavel_pratasavitski.soundplayhelper.pojo.songs.Song;

public class SoundsAdapter extends RecyclerView.Adapter<SoundsAdapter.SoundHolder> {

    private List<Song> songs;
    private Context context;

    public SoundsAdapter(Context con, List<Song> songs) {
        this.context = con;
        this.songs = songs;
    }

    @Override
    public SoundsAdapter.SoundHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.adapter_sounds, parent, false);

        return new SoundHolder(v);
    }

    @Override
    public void onBindViewHolder(SoundsAdapter.SoundHolder holder, int position) {
        if (songs.isEmpty()) {
            return;
        }

        holder.nameTextView.setText(
                songs.get(position).getName());
        holder.descriptionTextView.setText(
                songs.get(position).getOriginalName());

//        GlideApp.with(context)
//                .load(null)
//                .defaultOptions()
//                .transition(DrawableTransitionOptions.withCrossFade())
//                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public void setData(List<Song> songList) {
        songs = songList;
        notifyDataSetChanged();
    }

    public class SoundHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.adapter_sounds_image_view)
        ImageView imageView;
        @BindView(R.id.adapter_sounds_name_text_view)
        TextView nameTextView;
        @BindView(R.id.adapter_sounds_description_text_view)
        TextView descriptionTextView;

        public SoundHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}