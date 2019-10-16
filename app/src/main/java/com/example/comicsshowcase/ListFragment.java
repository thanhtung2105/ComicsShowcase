package com.example.comicsshowcase;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment implements ComicAdapter.onClick_comicItem {
    RecyclerView recyclerView;
    List<ComicModel> comicList;
    ImageButton add_comic;
    ComicDB_CRUD comicDB_crud;

    public ListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        comicList = new ArrayList();
        comicDB_crud = ComicDB_CRUD.getInstance(getContext());
        comicList = comicDB_crud.loadComic();
        comicList.add(new ComicModel("https://cdn1.imggmi.com/uploads/2019/10/16/c2745ba60804de7122f214d585ee28ed-full.jpg", "Tuyển tập tranh MASASHI KISHIMOTO",
                "Artbook Naruto: Uzumaki là cuốn đầu tiên trong bộ 3 Artbook - Tuyển tập tranh màu Naruto của tác giả Masashi Kishimoto. Sách ra mắt nhân sự kiện trở lại của phiên bản Naruto 2018 do Nhà xuất bản Kim Đồng phát hành."));
        comicList.add(new ComicModel("https://cdn1.imggmi.com/uploads/2019/10/16/6e5f43cbcb67c33bf93a13c77705a222-full.jpg", "Naruto Vol.1 Limited Edition",
                "Naruto Vol.1 Limited Edition là phiên bản giới hạn của cuốn Naruto Vol.1. Ngoài phần nội dung tương đương với bản bình thường, bản giới hạn sẽ có phần bìa áo hoàn toàn mới, với hình ảnh Naruto lấy từ bức tranh mà tác giả Kishimoto vẽ cho bìa tạp chí Jump - số 43 phát hành năm 1999. Đây cũng là lần đầu ra mắt của Naruto trên tạp chí Jump."));
        comicList.add(new ComicModel("https://cdn1.imggmi.com/uploads/2019/10/16/ff15747ba9211878007695b54c964d9c-full.jpg", "Naruto Vol.1   'Uzumaki Naruto'",
                "Chuyện xảy ra ở làng Lá với nhân vật chính là Naruto, học sinh trường đào tạo Ninja, chuyên đi quấy rối khắp làng!! Naruto có một ước mơ to lớn là đạt được danh hiệu Hokage - Một vị trí dành cho Ninja ưu tú nhất - Và vượt qua các Ninja tiền nhiệm. Tuy nhiên, bí mật về thân thế của Naruto là…!?"));
        comicList.add(new ComicModel("https://cdn1.imggmi.com/uploads/2019/10/16/7a3ae144c1aa9072a8d968d7271ec6be-full.jpg", "Naruto Vol.2   Vị khách khó ưa",
                "Sau khi vượt qua bài kiểm tra khó nhằn của thầy Kakashi, 3 Genin Naruto, Sasuke và Sakura nhận được một nhiệm vụ lớn! Cả nhóm phải bảo vệ ông Tazuna, một kĩ sư xây cầu nổi tiếng. Tuy nhiên, có một bóng đen bí ẩn đang đuổi theo họ…!!"));
        comicList.add(new ComicModel("https://cdn1.imggmi.com/uploads/2019/10/16/e6110d8f657a51fe56b579033d2e838f-full.jpg", "Naruto Vol.3   Ước mơ...!!!",
                "Sasuke ngã gục vì che chở cho Naruto…!! Khi đó, sự phẫn nộ cùng nỗi buồn vô tình đã gây ra những biến đổi cho Naruto. Số phận của Haku, kẻ bị đánh bại bở cú thiết quyền đầy giận dữ của Naruto sẽ thế nào…!? Kết quả trận đấu của Zabuza và Kakashi sẽ ra sao!?"));
        comicList.add(new ComicModel("https://cdn1.imggmi.com/uploads/2019/10/16/7b1ab27e27913da8471c9398fa0ff819-full.jpg","Naruto Vol.4   Cây cầu mang tên người anh hùng!!",
                "Sasuke ngã gục vì che chở cho Naruto…!! Khi đó, sự phẫn nộ cùng nỗi buồn vô tình đã gây ra những biến đổi cho Naruto. Số phận của Haku, kẻ bị đánh bại bở cú thiết quyền đầy giận dữ của Naruto sẽ thế nào…!? Kết quả trận đấu của Zabuza và Kakashi sẽ ra sao!?"));
        comicList.add(new ComicModel("https://cdn1.imggmi.com/uploads/2019/10/16/ec27eaef456687614bf7e6be8529a921-full.jpg","Naruto Vol.5   Đấu thủ!!",
                "Được thầy Kakashi tiến cử, nhóm của Naruto đã bước vào Kì thi tuyển Chunin! Từ kẻ mạnh cho đến những kẻ kì lạ, toàn bộ đấu thủ đều tập trung về đây…!! Và kì thi tuyển đã bắt đầu…!?"));
        comicList.add(new ComicModel("https://cdn1.imggmi.com/uploads/2019/10/16/8da043320950ebf72a10b07c5ae02b06-full.jpg","Naruto Vol.6   Quyết tâm của Sakura!!",
                "Vòng thứ 2 của kì thi tuyển Chunin đã bắt đầu!! Nhóm Naruto bước vào cuộc chiến giành quyển trục trong khu rừng kì lạ. Tuy nhiên đằng sau đó, lai lịch bất minh của một số kẻ cũng dần được hé mở. Kì thi tàn khốc có thể lấy đi sinh mạng của bất cứ thí sinh nào rồi sẽ ra sao…!?"));
        comicList.add(new ComicModel("https://cdn1.imggmi.com/uploads/2019/10/16/f6561265876f6a80e490bf402b2a2d81-full.jpg","Naruto Vol.7   Con đường duy nhất...!!",
                "“Sasuke nhất định sẽ cần tới ta”. Orochimaru đã để lại câu nói bí ẩn đó và biến mất trước mắt nhóm Naruto…Vì ảnh hưởng của ấn chú mà Orochimaru để lại, Sasuke đã hạ nhóm Ninja âm thanh trong tình trạng kích thích tột độ. Mục đích của Orochimaru là gì!? Trong khi đó, kì thi tuyển Chunin vẫn tiếp tục diễn ra…"));
        comicList.add(new ComicModel("https://cdn1.imggmi.com/uploads/2019/10/16/f08c2a19056a391bc8e3a273622f3651-full.jpg","Naruto Vol.8   Trận chiến sống còn!!",
                "Sau khi vượt qua vòng 2, nhóm Naruto tiếp tục tiến vào vòng 3. Nhưng có một vòng đấu loại diễn ra trước khi bắt đầu vòng 3. Kabuto rút lui ngay trước vòng thi! Số thí sinh còn lại 20 người, tổ chức thi đấu theo hình thức 1 đấu 1...!!"));
        comicList.add(new ComicModel("https://cdn1.imggmi.com/uploads/2019/10/16/dd302d8d581f65ce1b2c75731f07c3c8-full.jpg","Naruto Vol.9   Neji và Hinata",
                "Vòng thi thứ 3!! Cuộc tranh tài của 20 thí sinh xuất sắc đã gay cấn ngay từ những trận đầu! Sasuke, Shino và Kankuro giành phần thắng, trận đấu giữa Sakura VS. Ino cũng lên đến cao trào. Và Naruto sẽ thượng đài thế nào đây!? Sau đó là một trận đấu gây nhiều tranh cãi nữa…!!"));
        comicList.add(new ComicModel("https://cdn1.imggmi.com/uploads/2019/10/16/41173f65ee00946c9615953b51e493d8-full.jpg","Naruto Vol.10   Ninja kiệt xuất...!!",
                "Tiếp tục là những trận tranh tài rực lửa của vòng thi thứ 3! Màn đối đầu giữa một bên là Gaara - người sử dụng chiếc hồ lô cát đầy lợi hại - với một bên là Lee - chuyên gia tôi luyện Thể thuật! Liệu với thể thuật hơn người, Lee có đủ sức đánh bại Gaara…!?"));
        comicList.add(new ComicModel("https://cdn1.imggmi.com/uploads/2019/10/16/cc48612b3f5b70f61b49984d8f60781c-full.jpg","Naruto Vol.11   Nhận tui làm đệ tử nha!?",
                "Trước thềm trận đấu chính của vòng 3, Naruto đã tiến hành tập luyện với một Tiên Nhân Cóc bí ẩn... Trong khi đó, Kabuto và Jonin làng Cát Baki gần như thờ ơ trước việc Dosu - người đã thách đấu với Gaara - bị hạ gục trong phút chốc!! Khế ước bí mật đáng sợ dần dần được sáng tỏ!!"));
        comicList.add(new ComicModel("https://cdn1.imggmi.com/uploads/2019/10/16/025da1f046f4e6cbfa2017c86902d8e5-full.jpg","Naruto Vol.12   Bay cao!!",
                "Jonin xuất chúng Neji VS. Naruto đang bị thương tơi tả!! Ai sẽ là người giành chiến thắng!? Kì thi tuyển Chunin đã bước vào vòng cuối cùng. Naruto cũng dốc toàn bộ sức lực để đấu với thiên tài Neji mang trên mình ấn chú!! Kết cuộc trận đấu sẽ sớm được định đoạt…!!"));

        ComicAdapter comicAdapter = new ComicAdapter(getContext(), comicList, this);
        recyclerView.setAdapter(comicAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));

        add_comic = view.findViewById(R.id.add_comic);
        add_comic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.frame_layout, new Fragment_AddComic()).addToBackStack(null).commit();
            }
        });

        return view;
    }

    @Override
    public void onClick(ComicModel comicModel) {
        getFragmentManager().beginTransaction().replace(R.id.frame_layout, new ComicFragment(comicModel)).addToBackStack(null).commit();
    }


}