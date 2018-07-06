# 하단 감지 RecyclerView + 프로그래스바

## 1. RecyclerView.Adapter를 만들때 ProgressRvAdt를 상속 받는다.
ProgressRvAdt의 기능은 현재 리스트의 로드가 끝났는지 안끝났는지에따라 프로그레스바 노출여부를 판단해주는 기능을 한다.
```gradle
public class RvAdt extends ProgressRvAdt<RecyclerView.ViewHolder> {..
```

## 2. getItemCount 시 ProgressRvAdt의 getItemCount()를 더해준다
리스트의 로드가 끝나지 않았다면 현재 아이템에 1을 더해줘서 마지막 아이템을 프로그레스바 처리해줘야한다.
```gradle
    @Override
    public int getItemCount() {
        int count = 0;
        if (myData != null)
            count = myData.size();
        return count + super.getItemCount();
    }
```
## 3. ProgressRvAdt의 getItemViewType에서 현재 뷰 타입이 프로그래스바인지 알 수 있다.
리스트의 로드가 끝나지 않았다면 마지막 아이템의 뷰타입을 프로그래스바 뷰타입으로 전달해준다.
```gradle
ProgressRvAdt.class
@Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1) {
            return loadFinished ? 0 : VIEW_TYPE_PROGRESS;
        } else {
            return 0;
        }
    }
```
## 4. 마지막 데이터를 받았을때 setLoadFinished(true)를 호출해준다.
로드 finish를 호출해주면 더이상 프로그레스바 처리를 하지 않는다.
```gradle
if (newMyData.size() < 10) {
            rvAdt.setLoadFinished(true);
        } else {
            isLast = false;
        }
```