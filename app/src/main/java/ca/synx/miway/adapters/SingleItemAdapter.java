/*
 * Copyright (c) 2014, SYNX (Gideon Bakx)
 *
 *  THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package ca.synx.miway.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ca.synx.miway.app.R;
import ca.synx.miway.interfaces.IListItem;

public class SingleItemAdapter<T extends IListItem> extends BaseAdapter<T> {

    public SingleItemAdapter(List<T> list, int listViewResourceID, boolean showNextIcon, Context ctx) {
        super(list, listViewResourceID, showNextIcon, ctx);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        View v = view;
        T t = null;
        Holder holder = new Holder();

        // First let's verify the convertView is not null
        if (view == null) {

            // Inflate the new layout
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.listview_item_single, null);

            if (!showNextIcon) {
                ImageView imageView = (ImageView) v.findViewById(R.id.nextitem);
                imageView.setVisibility(View.GONE);
            }

            // Now we can fill the layout with the right values
            TextView titleView = (TextView) v.findViewById(R.id.title);

            holder.title = titleView;

            v.setTag(R.id.tag_id_1, holder);
        } else {
            holder = (Holder) v.getTag(R.id.tag_id_1);
        }

        t = mList.get(position);

        v.setTag(R.id.tag_id_2, (T) t);

        holder.title.setText(t.getTitle());

        return v;
    }

    private static class Holder {
        public TextView title;
    }
}

