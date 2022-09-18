# Discoord

플레이어의 현재 좌표를 Discord에 공유하는 Bukkit 플러그인

## 설정

config.yml

```yaml
webhookUrl: https://discord.com/api/webhooks/{webhook.id}/{webhook.token}
```

좌표를 공유하고자 하는 채널에 웹후크를 생성하고 해당 웹후크의 URL을 복사하세요.

## 사용 방법

### 현재 좌표를 채팅으로 공유

```
/coord <장소명>
```

### 현재 좌표를 Discord에 공유

```
/discoord <장소명>
```

### 예시

```
/coord 마을
```

```
/discoord 마을
```