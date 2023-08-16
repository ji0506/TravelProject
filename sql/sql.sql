-- --------------------------------------------------------
-- 호스트:                          3.35.159.211
-- 서버 버전:                        10.3.38-MariaDB-0ubuntu0.20.04.1 - Ubuntu 20.04
-- 서버 OS:                        debian-linux-gnu
-- HeidiSQL 버전:                  11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- travel 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `travel` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci */;
USE `travel`;

-- 테이블 travel.board 구조 내보내기
CREATE TABLE IF NOT EXISTS `board` (
  `brd_no` int(11) NOT NULL AUTO_INCREMENT,
  `cnt` int(11) NOT NULL,
  `content` longtext DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `cate_no` int(11) NOT NULL,
  `reg_date` datetime(6) DEFAULT current_timestamp(6),
  `title` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `vote_no` int(11) NOT NULL,
  PRIMARY KEY (`brd_no`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 travel.board:~38 rows (대략적) 내보내기
DELETE FROM `board`;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` (`brd_no`, `cnt`, `content`, `file_name`, `cate_no`, `reg_date`, `title`, `user_id`, `vote_no`) VALUES
	(1, 0, '입신부의 임신 기간에 따라 가능여부가 달라집니다.', NULL, 2, '2023-08-16 03:15:44.377757', '임산부인데 비행기 탈 수 있나요?', NULL, 0),
	(2, 0, '항공 예약 전 항공사 고객센터로 반입가능여부와 검역 규정을 확인하여 주시기 바랍니다.', NULL, 2, '2023-08-16 03:15:44.385574', '애완동물 데리고 탑승할 수 있나요?', NULL, 0),
	(3, 0, '유효기간은 최소 6개월 이상 남아 있어야 합니다.', NULL, 2, '2023-08-16 03:15:44.395299', '예약 시 여권 유효기간이 얼마나 남아 있어야 하나요?', NULL, 0),
	(4, 0, '항공 결항 시 손해에 대한 보상은 여객운송약관과 소비자 피해보상규정을 근거로 처리되어지며', NULL, 2, '2023-08-16 03:15:44.403141', '기상 등의 이유로 결항 시 손해에 대한 보상은 어떻게 되나요?', NULL, 0),
	(5, 0, '수하물의 손상 지연 또는 분실 시 배상책임 한도액은 위탁수하물의 경우 1kg당 미화 20불(또는 그 상당액), 휴대수하물의 경우 여객 1인당 미화 400불입니다.', NULL, 2, '2023-08-16 03:15:44.410958', '수하물 분실 시 배상 한도는 어떻게 되나요?', NULL, 0),
	(6, 0, '취소시점에 따라서 전액 또는 수수료 발생시 차감후 해당 ID로 환불 처리 됩니다. 포인트의 잔여 유효기간은 최초 적립 시와 동일하게 적용되며, 포인트 환불 절차는 영업일 기준 3~5일 정도 소요될 수  있습니다. ', NULL, 3, '2023-08-16 03:15:44.418290', '결제 취소 시 사용한 포인트는 어떻게 되나요?', NULL, 0),
	(7, 0, '실제여행객을 대리하거나 또는 함께여행하는 경우, 여행객을 대표해서 예약이 가능합니다. 단, 예약시 실제 여행하시는 고객님들의 정보(영문명,생년월일,연락처,여권정보등)를 정확하게 여행사로 알려주셔야 항공권등 예약이 확정이 될 수 있습니다. ', NULL, 3, '2023-08-16 03:15:44.425533', '부모님(지인) 여행을 대신 예약 할 수 있나요?', NULL, 0),
	(8, 0, '네, 가능합니다. 실제여행자분 명의의 신용카드와 현금의 복합결제가 가능하며, 현금 결제부분은 현금영수증 발행 신청시 발급해드리고 있습니다.', NULL, 3, '2023-08-16 03:15:44.431973', '카드와 현금으로 복합결제가 가능한가요?', NULL, 0),
	(9, 0, '동행자와 개별결제가 가능하며, 각각의 본인 명의 카드 또는 은행 계좌를 이용하 실 수 있습니다. 자세한 사항은 여행 담당자를 통해서 문의 바랍니다.', NULL, 3, '2023-08-16 03:15:44.441337', '동행자와 개별 결제 가능할까요?', NULL, 0),
	(10, 0, '여행박사 상품권은 일부 여행상품을 제외하고 결제시 사용가능합니다. 자세한 사항은 상품권 안내 페이지를 참조해주세요.', NULL, 3, '2023-08-16 03:15:44.448653', '여행박사 상품권 결제에 대해서 궁금합니다.', NULL, 0),
	(11, 0, '네 가능합니다. 기존 여권(녹색)은 유효기간이 남아있는 동안 문제없이 사용이 가능합니다. ', NULL, 4, '2023-08-16 03:15:44.456466', '차세대여권(남색)이 나왔는데 기존(녹색) 여권을 쓸수 있나요?', NULL, 0),
	(12, 0, '여권법은 만 18세 미만인 경우 미성년자로서 법정대리인의 동의를 받도록 하고 있습니다. 따라서 만 18세가 되는 해의 생일이 지나지 않은 사람은 여권법상 미성년자에 해당합니다.  ', NULL, 4, '2023-08-16 03:15:44.464185', '여권발급시 미성년자의 나이 계산은 어떻게 하나요?', NULL, 0),
	(13, 0, '여권 유효기간 만료 전까지는 여권 사용이 가능합니다. 간혹, 입출국 심사 시 영아의 빠른 성장으로 여권사진 교체를 언급하는 경우가 있으니, 희망 시에 교체된 사진으로 여권 재발급(비용 발생) 가능합니다. ', NULL, 4, '2023-08-16 03:15:44.472416', '영아의 경우 성장으로 얼굴이 바뀌는데 신생아때 만든 여권을 사용하는데 문제가 없나요?', NULL, 0),
	(14, 0, '여권을 분실하였을 경우는 즉시 가까운 여권 발급기관(전국 249개 광역 및 기초 자치단체)에 신분증을 지참하여 여권명의인이 직접 여권 분실 사실을 신고하시기 바랍니다. 분실 신고를 하기 전에 \'경찰청 유실물 통합포털(www.lost112.go.kr)\'에 접속, [습득물 상세검색]서비스를 이용하여 여권 습득 여부를 먼저 확인하시기 바랍니다. 만 18세 이상 성인의 경우 반드시 본인이 직접 신고해야하며 대리로 분실신고가 가능한 사유는 다음과 같습니다. 1) 의전상 필요한 경우(대통령, 국회의장, 대법원장, 헌번재판소장, 국무총리만 해당) 2) 본인이 직접 신청할 수 없을 정도의 신체적?정신적 질병, 장애나 사고 등으로 인하여 대리인에 의한 신청이 특별히 필요한 경우(전문의의 진단서 또는 소견서 구비) 3) 18세 미만인 미성년자인 경우(해외여행 중 여권을 분실하였을 경우는 가까운 대사관 또는 총영사관에 여권 분실 신고를 하고 단수여권을 발급받으시기 바랍니다.) 단, 여권을 재발급 받은 경우 여행사로 변경된 여권 정보를 알려주시기 바랍니다.', NULL, 4, '2023-08-16 03:15:44.479890', '여권 분실시 어떻게 해야되나요?', NULL, 0),
	(15, 0, '그렇지않습니다. 개인정보보호법 제17조, 59조, 71조에 의거하여 정보주체(여권소지인)의 동의가 없으면 여권정보 일체를 제3자에게 제공할 수 없도록 규정하고 있습니다. 전화만으로는 본인확인 확인이 어려우므로 개인 정보 보호를 위해서 여권 정보를 제공할 수 없도록 되어 있습니다. (참고사항) 이미 발급되어 교부 처리된 유효한 여권에 한해 본인 명의 공인인증서로 로그인하여 행정안전부의 정부24 (www.gov.kr) 또는 영사민원24(www.consul.mofa.go.kr)에서 여권번호, 로마자성명(영문이름), 여권유효기간에 관한 여권정보를 확인할 수 있음을 안내하기 바랍니다. (생활정보 서비스 이용에 동의가 되어있지 않은 경우 여권정보가 보이지 않음)', NULL, 4, '2023-08-16 03:15:44.487253', '항공권을 급하게 예약해야되는데 관련기관에서 전화로 여권번호/영문명을 알려주나요?', NULL, 0),
	(16, 0, '[휴면고객안내] 1년간 미이용시 휴면상태로 전환됩니다. 휴면해제는 회원가입시 입력하신 이메일 또는 휴대전화로 인증후 사용이 가능합니다. 회원가입 정보를 잊으신 경우 고객센터 또는 질문과 답변게시판으로 문의 바랍니다.', NULL, 5, '2023-08-16 03:15:44.494977', '회원아이디가 휴면상태로 로그인이 안됩니다.', NULL, 0),
	(17, 0, '[PC/Mobile web&app]여행박사회원 로그인→마이페이지→정보수정→마케팅 정보 수신동의(이메일,문자) 동의 또는 동의안함 설정을 통해서 이용 가능합니다.', NULL, 5, '2023-08-16 03:15:44.502280', '광고 수신 알림 설정을 변경하고 싶습니다.', NULL, 0),
	(18, 0, '여행 종료후 회원 가입을 하시는 경우, 이미 종료된 여행의 조회는 담당자를 통해서 회원아이디와 다녀오신 여행의 연동처리후 마이페이지에서 조회가 가능합니다. 단, 마이페이지 조회는 여행종료 1년까지 가능하며 추가 문의는 질문과 답변 게시판 또는 고객센터로 바랍니다.', NULL, 5, '2023-08-16 03:15:44.509566', '여행종료후 회원가입했는데 마이페이지에서 여행이력이 조회가 안됩니다.', NULL, 0),
	(19, 0, '[PC/Mobile web&app]마이페이지→정보수정 메뉴를 통해서 이용 가능합니다.', NULL, 5, '2023-08-16 03:15:44.516838', '이메일과 연락처등 회원정보가 변경되었습니다.', NULL, 0),
	(20, 0, '내정보에 등록한 정보로 아이디/비밀번호 찾기가 가능합니다. (휴대폰 or 이메일 or 생년월일)', NULL, 5, '2023-08-16 03:15:44.526621', '아이디/비밀번호를 잊어버렸어요', NULL, 0),
	(21, 0, '아이디는 변경이 불가능합니다.따라서 가입 시 아이디를 신중하게 선택해주시기 바랍니다.만약 아이디 변경을 원하시는 경우 기존의 아이디를 해지하고 새로 가입이 필요합니다.', NULL, 5, '2023-08-16 03:15:44.537215', '기존 아이디를 다른 아이디로 변경할 수 있나요?', NULL, 0),
	(22, 0, '여행증명서는 여권을 갈음하는 증명서로, 유효기간은 1년 내(행정제재자의 편도 귀국용은 1개월 이내)로 부여하고 발행목적이 성취된 때 그 효력이 상실됩니다. ', NULL, 4, '2023-08-16 03:15:44.544907', '여행증명서는 무엇인가요?', NULL, 0),
	(23, 0, '훼손된 여권으로 출입국시 출입국 거부 및 구금등의 불이익이 발생될 수 있습니다. 특히 여권에 낙서, 메모를 하거나 기념스탬프 날인, 페이지를 임의로 뜯어내는 경우, 신원정보 면에 얼룩이 묻은 경우, 여권표지 손상 등은 모두 훼손된 여권으로 간주되며, 훼손된 여권은 유효하지 않은 신분증으로써 출입국 심사는 물론 항공권 발권과정에서도 불이익이 발생할 수 있습니다. 여권 훼손에 따른 출입국 거부 사례가 발생할 경우, 해당국 소재 대사관에 방문하여 단수여권을 재발급 받아야 하는 불편이 발생할 뿐 아니라, 단수여권 소지자의 출입국을 제한하는 국가도 있기 때문에 이후 여행 일정에도 지장을 초래할 수 있습니다.(해외에서 단시간 내 여권 발급이 필요한 경우, 단수여권 발급만 가능) 해외 체류 또는 방문 중 위급상황이 발생하는 경우에는 해당국가에 소재한 대사관 또는 외교부 영사콜센터로 연락하여 필요한 도움을 받으시기 바랍니다.', NULL, 4, '2023-08-16 03:15:44.552754', '여권에 낙서가 있는데 사용 가능한가요?', NULL, 0),
	(24, 0, '여권발급신청서, 여권용 사진 1매 (6개월 이내에 촬영한 사진), 신분증, 병역관련서류(해당자)_병역 미필자 (18세~37세) : 제출 서류 없음, 5년 복수여권 발급 (단, 여권발급과 별도로 출국시에는 국외여행허가서 필요)_37세까지 국외여행허가를 받은 자 : 10년 복수여권 발급_전역 6개월 미만의 대체의무 복무중인 자 : 전역예정증명서 및 복무확인서 제출시 10년 복수 여권 발급', NULL, 4, '2023-08-16 03:15:44.560976', '여권 발급 서류', NULL, 0),
	(25, 0, '여권,비자를 준비할 충분한 시간이 있다면 예약 가능합니다.', NULL, 4, '2023-08-16 03:15:44.568675', '여권, 비자가 없는데 예약할 수 있나요?', NULL, 0),
	(26, 0, '현재 일본의 경우 90일까지 무비자 입국이 되었으나, 일본 비자의 경우 처음 신청하시는 분들은 일본 출입국 횟수 제한이 없는 복수비자 1년짜리가 발급됩니다.직업이 공무원이시거나 교사, 의사이신 분들의 경우 심사를 통해서 5년짜리가 발급되어지고 이전에 일본비자를 여러 번 받은 경험이 있고 일본 출입국을 문제없이 하신 분들이라면 간혹 5년짜리가 발급되기도 합니다.', NULL, 4, '2023-08-16 03:15:44.575975', '비자의 기간은 얼마나 되나요?', NULL, 0),
	(27, 0, '결제가 완료된 후 항공권 발행이 완료되면 메일로 발송 후 문자 안내를 드립니다.직접 출력하셔서 소지하신 후 공항에서 해당 항공사에 제시하시면 됩니다.', NULL, 2, '2023-08-16 03:15:44.584271', '항공권은 어떻게 받나요?', NULL, 0),
	(28, 0, '적용기간은 출발 일을 의미하며, 해당 기간 내에 출발하셔야 해당요금을 적용 받으실 수 있습니다.유효기간은 현지(목적지)에서 체류할 수 있는 기간을 나타냅니다.', NULL, 2, '2023-08-16 03:15:44.592571', '항공권 구입시 나타나는 적용기간과 유효기간이 어떻게 다른가요?', NULL, 0),
	(29, 0, '항공권을 구매하신 후 항공사나 여행사에 아무런 연락 없이 탑승하지 않는 것을 NO-SHOW라 하며, 이런 경우 환불금액은 없습니다. 탑승이 불가한 경우에는 반드시 항공사로 연락을 주셔야만 추후 일부 환불이라도 받으실 수 있습니다.', NULL, 2, '2023-08-16 03:15:44.600828', '노쇼(NO-SHOW)란 무엇인가요?', NULL, 0),
	(30, 0, '현재 139개 항공사가 사전좌석배정을 받으실 수 있습니다. 대한항공의 경우는 좌석을 많이 오픈시켜 놓지 않기 때문에 앞 좌석으로는 힘든 편이며 웬만한 항공사는 사전좌석배정을 받으실 수 있습니다. 단, 단체항공권의 경우에는 사전좌석배정이 불가합니다.', NULL, 2, '2023-08-16 03:15:44.614418', '좌석배정 미리 받을 수 있나요? (저가항공사 제외)', NULL, 0),
	(31, 0, '안전을 위하여 기내 휴대품으로 가지고 가실 수 없는 물품을 SRI(Security Removed Item)라고 하며, 이러한 물품은 다음과 같은 것이 있습니다.가) 자를 수 있는 것은 길이,종류와 관계없이 반입 금지나) 기내식용 금속나이프, 종이커터, 장식용 주머니칼, 스위스 나이프다) 얼음 깨는 송곳, 와인 오프너, 가위 및 면도기 등', NULL, 2, '2023-08-16 03:15:44.622749', '기내에 가지고 갈 수 없는 물품은 어떤 것이 있나요?', NULL, 0),
	(32, 0, '담당자가 항공사를 통해서 가부여부를 확인 할 수있습니다. 발권된 항공권이 취소/변경이 가능한 경우가능하며(수수료발생), 항공권에 따라서 취소/변경이 전면적으로 불가한 경우도 있으니, 담당자에게 예약상담시 반드시 해당 사항을 알려야합니다.', NULL, 1, '2023-08-16 03:15:44.631104', '패키지 여행 종료후 항공권 일정 변경이 가능한가요?', NULL, 0),
	(33, 0, '자유여행중인 경우, 직접 가까운 경찰서에 신고하시고 대사관을 통해서 임시여권을 발급 받아야합니다. 패키지여행의 경우 인솔자/가이드에게 사실을 알리고 동일한 절차를 거쳐서 임시여권을 발급 받아야합니다. 이경우 미리 항공사를 통해서 변경된 여권정보로 재발행(수수료발생) 받지 않으면 탑승이 거부 될 수 있습니다.', NULL, 1, '2023-08-16 03:15:44.638837', '여행중 여권을 분실한 경우 어떻게 해야되나요?', NULL, 0),
	(34, 0, '여행지역에 따라서 상이합니다. 단, 유럽/일본의 경우 인솔자가 동행하는 경우가 대부분이며, 이외 인솔자가 동행하지 않는 경우 현지에서 가이드와 만나서 여행을 하게 됩니다. ', NULL, 1, '2023-08-16 03:15:44.647002', '모든 패키지여행에 인솔자가 동행하나요?', NULL, 0),
	(35, 0, '여행종료후 여행사가 타인의 정보를 제3자에게 제공하는 것은 불가합니다. 다만, 개인정보가 필요한 대상자에게 고객님의 연락처를 제공하고, 상대가 동의시 직접 연락할 수 있도록 전달을 해드릴 수 있습니다. 필요시 당사 홈페이지 질문과답변 게시판으로 문의 바랍니다. ', NULL, 1, '2023-08-16 03:15:44.654653', '패키지에 동행한 인솔자/가이드/여행객의 연락처를 알 수 있을까요?', NULL, 0),
	(36, 0, '네, 가능합니다, 다만 패키지여행의 경우 2인1실 기준으로 요금이 정해져있어서, 일정금액의 싱글비용이 발생되며 여행지역에 따라서 요금은 다릅니다. 희망시 동성의 1인 예약자가 있는 경우 객실조인을 통해서 2인1실로 지정될 수도 있습니다. ', NULL, 1, '2023-08-16 03:15:44.662502', '패키지여행에 혼자도 참여가능한가요?', NULL, 0),
	(37, 0, '인솔자는 출입국시 전일정 동안 고객님과 동행하며 편의를 제공해드리는 역할을 합니다. 고객님과 가까운곳에 머물며 현지에서 긴급상황 발생시 신속한 대응이 가능합니다. 가이드는 현지 관광일정 동안 관광지를 소개하고 일정을 소화하는 역할을 합니다. 현지에 대한 전문적인 지식을 보유하고 현지에 상황에 능동적으로 대응할 수 있는 역량을 갖추었기때문에 여행중 리더로서 안전하고 즐거운 여행의 길잡이가 됩니다. ', NULL, 1, '2023-08-16 03:15:44.671480', '인솔자와 가이드의 차이점은 무엇인가요?', NULL, 0),
	(38, 0, '패키지여행의 경우 일정 인원 이상 즉, 최소출발인원의 충족시 출발이 가능합니다.  예약인원이 최소출발인원에 미달인 경우 인원이 충족시까지 모객을 거쳐서 출발 확정이 되므로, 완료전까지는 대기예약 상태가 됩니다. 또 예약정원이 초과된 경우, 앞선 예약자의 취소 또는 현지 항공편, 호텔 등이 추가로 확보 될 때까지 대기예약이 됩니다. 대기 예약에서 예약이 확정된 경우 담당자가 개별 연락 또는 담당자에게 연락시 확정 확인이 가능합니다.  ', NULL, 1, '2023-08-16 03:15:44.679206', '\'대기예약\'은 무엇인가요?', NULL, 0);
/*!40000 ALTER TABLE `board` ENABLE KEYS */;

-- 테이블 travel.categorie 구조 내보내기
CREATE TABLE IF NOT EXISTS `categorie` (
  `cate_no` int(11) NOT NULL AUTO_INCREMENT,
  `cate_detail` varchar(20) DEFAULT NULL,
  `cate_name` varchar(20) DEFAULT NULL,
  `user_type_cd` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`cate_no`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 travel.categorie:~0 rows (대략적) 내보내기
DELETE FROM `categorie`;
/*!40000 ALTER TABLE `categorie` DISABLE KEYS */;
/*!40000 ALTER TABLE `categorie` ENABLE KEYS */;

-- 테이블 travel.notice 구조 내보내기
CREATE TABLE IF NOT EXISTS `notice` (
  `noti_no` int(11) NOT NULL AUTO_INCREMENT,
  `cnt` int(11) NOT NULL,
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `file_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `cate_no` int(11) NOT NULL,
  `reg_date` datetime(6) DEFAULT current_timestamp(6),
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `vote_no` int(11) NOT NULL,
  PRIMARY KEY (`noti_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- 테이블 데이터 travel.notice:~5 rows (대략적) 내보내기
DELETE FROM `notice`;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` (`noti_no`, `cnt`, `content`, `file_name`, `cate_no`, `reg_date`, `title`, `user_id`, `vote_no`) VALUES
	(1, 0, '안녕하세요 고객님,코로나19로 인한 입국 시 조치별 기준을 안내드립니다. * 대상 : 관광 및 방문목적(업무/출장등 기타 목적은 별도 확인 요망)* 출처 : 외교부해외안전여행 홈페이지 공지사항(2022. 9. 1. 17:00  게재 기준) ○ 코로나19가 전 세계로 확산됨에 따라 대부분의 국가들이 외국인을 대상으로 입국제한 조치를 실시하고 있습니다. 또한 다수 항공 노선이 두절됨에 따라 해외에서 격리되거나 고립되는 등 큰 불편을 겪을 가능성이 있습니다. 코로나19와 관련하여 해외입국자에 대한 입국제한 조치를 실시하고 있는 국가(지역)를 안내합니다.', NULL, 8, '2023-08-16 03:43:37.499546', '[외교부]세계 주요 조치별 입국제한 현황 안내(2022. 9. 1. 1700 게재 기준)', '탈출도우미', 0),
	(2, 0, '개인정보 처리방침이 아래와 같이 변경됨을 안내드립니다. - 변경된 개인정보 처리방침은 2022년 9월 29일자로 효력이 발생합니다. 고객님의 개인 정보를 보다 안전하게 보호하고 관리하기 위하여 기술적/관리적 조치를 강화하여, 개인정보보호 규정 및 행정안전부가 제정한 표준 개인정보보호지침을 준수하기 위해서 최선을 다하겠습니다.', NULL, 7, '2023-08-16 03:43:37.507659', '개인정보 처리방침 일부개정 사전안내(9/29)', '관리자', 0),
	(3, 0, ' 개인정보 처리방침이 아래와 같이 변경됨을 알려드립니다. - 변경된 개인정보 처리방침은 2022년 8월 16일자로 효력이 발생합니다. 개인정보보호 규정 및 정보통신부가 제정한 개인정보보호지침을 준수하기 위해 최선을 다하겠습니다.', NULL, 7, '2023-08-16 03:43:37.516913', '개인정보 처리방침 일부개정 사전안내(8/16)', '관리자', 0),
	(4, 0, '※ 2022년 8월 문자 알림 결제 시 카드 무이자 할부 안내  ※[5만원이상 / 2~6개월 무이자]국민카드, 농협카드, 현대카드, 삼성카드 [5만원이상 / 2~7개월 무이자] 비씨카드 * 해외여행, 국내여행, 일본호텔, 해외패스/티켓 결제 시에만 적용됩니다.', NULL, 7, '2023-08-16 03:43:37.524122', '[문자알림결제] 2022년 8월 카드 무이자 할부 이벤트 안내입니다.', '관리자', 0),
	(5, 0, '대한민국 전자여행허가제 (K-ETA) 시행 관련 하기 내용 안내드립니다. 무사증으로 입국 가능한 외국인에 대해 의무적용되오니 참고 부탁드립니다. ○무사증 입국 가능 외국인에 대한 신속 입국 지원 및 부적합 대상에 대한 입국심사 강화 일환으로 사전에 온라인으로 개인 및 여행관련 정보를 입력하여 여행허가를 받도록 하는 제도 ○ 시행시기 : 2021년 9월 1일부 (KST 00시, 도착일 기준)', NULL, 8, '2023-08-16 03:43:37.531488', '대한민국 전자여행허가제 (K-ETA) 시행 관련(외국인 입국관련)', '관리자', 0);
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;

-- 테이블 travel.product 구조 내보내기
CREATE TABLE IF NOT EXISTS `product` (
  `pro_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '상품번호',
  `pro_continent` varchar(20) DEFAULT NULL COMMENT '대륙',
  `pro_country` varchar(20) DEFAULT NULL COMMENT '나라',
  `pro_city` varchar(20) DEFAULT NULL COMMENT '도시',
  `pro_name` varchar(50) DEFAULT NULL COMMENT '상품이름',
  `pro_airplane` varchar(10) DEFAULT NULL COMMENT '항공편',
  `pro_departure` datetime DEFAULT NULL COMMENT '출발일',
  `pro_arrive` datetime DEFAULT NULL COMMENT '도착일',
  `pro_plan` int(4) NOT NULL COMMENT '기간',
  `pro_adult` int(3) NOT NULL COMMENT '성인가격',
  `pro_minor` int(3) NOT NULL COMMENT '소인가격',
  `pro_seat` int(3) NOT NULL COMMENT '잔여상품수',
  PRIMARY KEY (`pro_no`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 travel.product:~6 rows (대략적) 내보내기
DELETE FROM `product`;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`pro_no`, `pro_continent`, `pro_country`, `pro_city`, `pro_name`, `pro_airplane`, `pro_departure`, `pro_arrive`, `pro_plan`, `pro_adult`, `pro_minor`, `pro_seat`) VALUES
	(12, '아시아', '베트남', '다낭', '베트남 다낭으로 가자~', '대한한공', '2023-08-30 00:00:00', '2023-08-31 00:00:00', 1, 498000, 298000, 58),
	(17, '아시아', '중국', '베이징', '중국 만리장성', '아시아나', '2023-09-27 00:00:00', '2023-09-30 00:00:00', 3, 498000, 240000, 10),
	(18, '아시아', '몽골', '울란바토르', '몽골 울란바토르로 떠나자 ', '대한한공', '2023-09-07 00:00:00', '2023-09-13 00:00:00', 6, 414000, 240000, 17),
	(21, '유럽', '네덜란드', '잔세스칸스', '네덜란드 잔세스칸스로 떠나요~~', '아시아나', '2023-08-24 00:00:00', '2023-08-26 00:00:00', 2, 498000, 298000, 71),
	(22, '유럽', '독일', '밤베르크', '독일 밤베르크로 떠나요', '제주항공', '2023-09-04 00:00:00', '2023-09-06 00:00:00', 2, 498000, 298000, 28),
	(23, '유럽', '스위스', '인터라켄', '스위스 인터라켄으로 떠나자', '에어부산', '2023-09-20 00:00:00', '2023-09-26 00:00:00', 6, 580000, 178000, 31),
	(24, '유럽', '이탈리아', '베네치아', '이탈리아 베네치아로 떠나요', '에어부산', '2023-09-13 00:00:00', '2023-09-15 00:00:00', 2, 570000, 210000, 31),
	(25, '유럽', '체코', '프라하', '체코 프라하로 떠나요', '제주항공', '2023-08-23 00:00:00', '2023-08-26 00:00:00', 3, 640000, 214000, 28),
	(26, '아메리카', '멕시코', '과나후아토', '멕시코 과나후아토로 떠나자', '대한항공', '2023-09-20 00:00:00', '2023-09-23 00:00:00', 3, 598000, 280000, 51),
	(27, '아메리카', '미국', '라스베이거스', '미국 라스베이거스 가서 도박 조지자', '에어부산', '2023-08-30 00:00:00', '2023-09-01 00:00:00', 2, 640000, 200000, 7),
	(28, '아메리카', '브라질', '올린다', '브라질 올린다로 떠나자', '아시아나', '2023-09-18 00:00:00', '2023-09-20 00:00:00', 2, 780000, 370000, 49),
	(29, '아메리카', '케나다', '오타와', '케나다 오타와로 떠나요 ', '에어부산', '2023-08-24 00:00:00', '2023-08-26 00:00:00', 2, 515000, 212000, 20),
	(30, '아메리카', '에콰도르', '키토', '에콰도르 키토로 떠나요', '에어부산', '2023-09-26 00:00:00', '2023-09-28 00:00:00', 2, 740000, 540000, 22),
	(31, '오세아니아', '뉴질랜드', '오클랜드', '뉴질랜드 오클랜드 여행', '대한항공', '2023-08-24 00:00:00', '2023-08-26 00:00:00', 2, 580000, 280000, 14),
	(32, '오세아니아', '뉴질랜드', '퀸스타운', '뉴질랜드 퀸스타운으로 여행을 떠나요', '대한항공', '2023-08-29 00:00:00', '2023-09-01 00:00:00', 3, 684000, 280000, 61),
	(35, '아시아', '필리핀', '마닐라', '필리핀 마닐라로 떠나요 ', '대한항공', '2023-09-05 00:00:00', '2023-09-07 00:00:00', 2, 587000, 210000, 27),
	(36, '오세아니아', '호주', '시드니', '호주 시드니로 여행을 떠나요', '대한항공', '2023-08-24 00:00:00', '2023-08-26 00:00:00', 2, 790000, 200000, 14),
	(38, '오세아니아', '호주', '시드니(블루마운틴)', '호주 시드니의 블루마운틴으로 갑시다', '에어부산', '2023-09-13 00:00:00', '2023-09-15 00:00:00', 2, 740000, 287400, 21);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

-- 테이블 travel.product_detail 구조 내보내기
CREATE TABLE IF NOT EXISTS `product_detail` (
  `detail_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '게시글번호',
  `pro_no` int(11) NOT NULL COMMENT '상품번호',
  `detail_info` text DEFAULT NULL COMMENT '상품정보',
  `detail_image` varchar(255) DEFAULT NULL COMMENT '상품대표이미지',
  `schedule` text DEFAULT NULL COMMENT '일정',
  `detail_viewcnt` varchar(4) DEFAULT NULL COMMENT '조회수',
  PRIMARY KEY (`detail_no`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 travel.product_detail:~6 rows (대략적) 내보내기
DELETE FROM `product_detail`;
/*!40000 ALTER TABLE `product_detail` DISABLE KEYS */;
INSERT INTO `product_detail` (`detail_no`, `pro_no`, `detail_info`, `detail_image`, `schedule`, `detail_viewcnt`) VALUES
	(12, 12, '<p>베트남 최고의 여행지 다낭으로 가자&nbsp;</p>', '/02c57aa7-c4bd-4eb3-8fde-d793a6ad1760_베트남 다낭.jpg', '<p>인천 - 여행지 입국 절차</p>\r\n<p>여행지 관광투어 및 식사</p>\r\n<p>자유롭게 가고싶은 곳을 투어하는 시간 제공</p>\r\n<p>여행지 - 인천 입국 .</p>\r\n<p>&nbsp;</p>', '0'),
	(17, 17, '<p>만리장성 가자&nbsp;</p>', '/f08be88f-ffec-4adf-a639-c14962a48e50_중국 만리장성.jpg', '<p>인천 - 여행지 입국 절차</p>\r\n<p>여행지 관광투어 및 식사</p>\r\n<p>자유롭게 가고싶은 곳을 투어하는 시간 제공</p>\r\n<p>여행지 - 인천 입국 .</p>\r\n<p>&nbsp;</p>', '0'),
	(18, 18, '<p>몽골 울란바토르로 떠나가자</p>', '/ceaef0bf-e26b-4d40-910f-07116c087db4_몽골울란바토르 게르.jpg', '<p>인천 - 여행지 입국 절차</p>\r\n<p>여행지 관광투어 및 식사</p>\r\n<p>자유롭게 가고싶은 곳을 투어하는 시간 제공</p>\r\n<p>여행지 - 인천 입국 .</p>\r\n<p>&nbsp;</p>', '0'),
	(21, 21, '<p>네덜란드 잔세스칸스로 떠나요~~</p>', '/38a1ef0d-4e1a-4346-b575-4e7b97a87b30_네덜란드 잔세스칸스.jpg', '<p>인천 - 여행지 입국 절차</p>\r\n<p>여행지 관광투어 및 식사</p>\r\n<p>자유롭게 가고싶은 곳을 투어하는 시간 제공</p>\r\n<p>여행지 - 인천 입국 .</p>\r\n<p>&nbsp;</p>', '0'),
	(22, 22, '<p>독일밤베르크로 떠나요</p>', '/6362726f-d01f-4d3c-b209-fd79ebbd5025_독일 밤베르크.jpg', '<p>인천 - 여행지 입국 절차</p>\r\n<p>여행지 관광투어 및 식사</p>\r\n<p>자유롭게 가고싶은 곳을 투어하는 시간 제공</p>\r\n<p>여행지 - 인천 입국 .</p>\r\n<p>&nbsp;</p>', '0'),
	(23, 23, '<p>스위스 인터라켄으로 떠나자</p>', '/e3b39660-7d3b-4852-82f0-1d9a0d3e9e75_스위스 인터라켄.jpg', '<p>인천 - 여행지 입국 절차</p>\r\n<p>여행지 관광투어 및 식사</p>\r\n<p>자유롭게 가고싶은 곳을 투어하는 시간 제공</p>\r\n<p>여행지 - 인천 입국 .</p>\r\n<p>&nbsp;</p>', '0'),
	(24, 24, '<p>이탈리아 베네치아로 떠나요</p>', '/18c0ff4d-009f-4272-8b97-8a70351d731a_이탈리아 베네치아.JPG', '<p>인천 - 여행지 입국 절차</p>\r\n<p>여행지 관광투어 및 식사</p>\r\n<p>자유롭게 가고싶은 곳을 투어하는 시간 제공</p>\r\n<p>여행지 - 인천 입국 .</p>\r\n<p>&nbsp;</p>', '0'),
	(25, 25, '<p>체코 프라하로 떠나요</p>', '/458c909c-cd03-4951-9293-79aa9acb97b0_체코 프라하.JPG', '<p>인천 - 여행지 입국 절차</p>\r\n<p>여행지 관광투어 및 식사</p>\r\n<p>자유롭게 가고싶은 곳을 투어하는 시간 제공</p>\r\n<p>여행지 - 인천 입국 .</p>\r\n<p>&nbsp;</p>', '0'),
	(26, 26, '<p>멕시코 과나후아토로 떠나자</p>', '/78da50b1-d991-47d4-8f56-e8104f99e3bf_멕시코 과나후아토.JPG', '', '0'),
	(27, 27, '<p>미국 라스베이거스 가서 도박 조지자</p>', '/9fbfa13e-25ce-492f-a3e1-f4b3ceb930b4_미국라스베이거스.jpg', '<p>인천 - 여행지 입국 절차</p>\r\n<p>여행지 관광투어 및 식사</p>\r\n<p>자유롭게 가고싶은 곳을 투어하는 시간 제공</p>\r\n<p>여행지 - 인천 입국 .</p>\r\n<p>&nbsp;</p>', '0'),
	(28, 28, '<p>브라질 올린다로 떠나자</p>', '/2c1fc454-97c7-4daa-8a47-8942eaad10f2_브라질 올린다.jpg', '<p>인천 - 여행지 입국 절차</p>\r\n<p>여행지 관광투어 및 식사</p>\r\n<p>자유롭게 가고싶은 곳을 투어하는 시간 제공</p>\r\n<p>여행지 - 인천 입국 .</p>\r\n<p>&nbsp;</p>', '0'),
	(29, 29, '<p>케나다 오타와로 떠나요~</p>', '/8232a7c5-c41e-4b03-aca4-5c31d324f75c_케나다 오타와.jpg', '<p>인천 - 여행지 입국 절차</p>\r\n<p>여행지 관광투어 및 식사</p>\r\n<p>자유롭게 가고싶은 곳을 투어하는 시간 제공</p>\r\n<p>여행지 - 인천 입국 .</p>\r\n<p>&nbsp;</p>', '0'),
	(30, 30, '<p>에콰도르&nbsp; 보토 나시오날 대성당 멋있어요</p>', '/fda1fc0f-3f40-46c1-b67e-de1f769cb8e6_에콰도르 보토 나시오날 대성당.jpg', '<p>인천 - 여행지 입국 절차</p>\r\n<p>여행지 관광투어 및 식사</p>\r\n<p>자유롭게 가고싶은 곳을 투어하는 시간 제공</p>\r\n<p>여행지 - 인천 입국 .</p>\r\n<p>&nbsp;</p>', '0'),
	(31, 31, '<p>뉴질랜드 오클랜드 여행 떠나요</p>', '/3cf00416-3fff-41ea-9c77-0e461aa87f84_뉴질랜드 오클랜드.jpg', '<p>인천 - 여행지 입국 절차</p>\r\n<p>여행지 관광투어 및 식사</p>\r\n<p>자유롭게 가고싶은 곳을 투어하는 시간 제공</p>\r\n<p>여행지 - 인천 입국 .</p>\r\n<p>&nbsp;</p>', '0'),
	(32, 32, '<p>뉴질랜드 퀸스타운으로 여행을 떠나요</p>', '/41366afa-2d2c-4a61-ab17-d6b1aa5ef450_뉴질랜드 퀸스타운.jpg', '<p>인천 - 여행지 입국 절차</p>\r\n<p>여행지 관광투어 및 식사</p>\r\n<p>자유롭게 가고싶은 곳을 투어하는 시간 제공</p>\r\n<p>여행지 - 인천 입국 .</p>\r\n<p>&nbsp;</p>', '0'),
	(35, 35, '<p>필리핀 마닐라로 떠나요&nbsp;</p>', '/006115ae-8f06-4ca1-afb9-ab4a640da180_필리핀마닐라.jpg', '<p>인천 - 여행지 입국 절차</p>\r\n<p>여행지 관광투어 및 식사</p>\r\n<p>자유롭게 가고싶은 곳을 투어하는 시간 제공</p>\r\n<p>여행지 - 인천 입국 .</p>\r\n<p>&nbsp;</p>', '0'),
	(36, 36, '<p>호주 시드니로 여행을 떠나요</p>', '/156f4c8e-0a4b-4146-b284-28051f3ece78_호주 시드니.jpg', '<p>인천 - 여행지 입국 절차</p>\r\n<p>여행지 관광투어 및 식사</p>\r\n<p>자유롭게 가고싶은 곳을 투어하는 시간 제공</p>\r\n<p>여행지 - 인천 입국 .</p>\r\n<p>&nbsp;</p>', '0'),
	(38, 38, '<p>호주 시드니의 블루마운틴으로 갑시다</p>', '/3b11e346-cabd-4110-82a0-43c4aa4a4069_호주 블루마운틴.jpg', '<p>인천 - 여행지 입국 절차</p>\r\n<p>여행지 관광투어 및 식사</p>\r\n<p>자유롭게 가고싶은 곳을 투어하는 시간 제공</p>\r\n<p>여행지 - 인천 입국 .</p>\r\n<p>&nbsp;</p>', '0');
/*!40000 ALTER TABLE `product_detail` ENABLE KEYS */;

-- 테이블 travel.qna 구조 내보내기
CREATE TABLE IF NOT EXISTS `qna` (
  `qna_no` int(11) NOT NULL AUTO_INCREMENT,
  `qna_content` text DEFAULT NULL,
  `qna_title` varchar(40) DEFAULT NULL,
  `reg_date` datetime DEFAULT current_timestamp(),
  `cnt` int(11) NOT NULL DEFAULT 0,
  `user_id` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`qna_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 travel.qna:~0 rows (대략적) 내보내기
DELETE FROM `qna`;
/*!40000 ALTER TABLE `qna` DISABLE KEYS */;
INSERT INTO `qna` (`qna_no`, `qna_content`, `qna_title`, `reg_date`, `cnt`, `user_id`) VALUES
	(1, '<p>문의합니다.</p>', '문의합니다', '2023-08-16 16:11:03', 0, 'admin');
/*!40000 ALTER TABLE `qna` ENABLE KEYS */;

-- 테이블 travel.reservation 구조 내보내기
CREATE TABLE IF NOT EXISTS `reservation` (
  `rev_num` int(11) NOT NULL AUTO_INCREMENT,
  `pro_no` int(11) NOT NULL,
  `rev_adult` int(11) NOT NULL,
  `rev_minor` int(11) NOT NULL,
  `rev_name` varchar(50) DEFAULT NULL,
  `rev_phone` varchar(50) DEFAULT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  `rev_birth` varchar(50) DEFAULT NULL,
  `rev_email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`rev_num`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 travel.reservation:~0 rows (대략적) 내보내기
DELETE FROM `reservation`;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` (`rev_num`, `pro_no`, `rev_adult`, `rev_minor`, `rev_name`, `rev_phone`, `user_id`, `rev_birth`, `rev_email`) VALUES
	(2, 12, 1, 1, 'test', 'test', 'admin', 'test', 'test');
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;

-- 테이블 travel.user 구조 내보내기
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` varchar(11) NOT NULL,
  `auth_id` varchar(2) NOT NULL DEFAULT '02',
  `user_addr` varchar(50) DEFAULT NULL,
  `user_daddr` varchar(50) DEFAULT NULL,
  `user_cp` varchar(20) DEFAULT NULL,
  `user_email` varchar(20) DEFAULT NULL,
  `user_grade` varchar(2) DEFAULT NULL,
  `user_name` varchar(10) DEFAULT NULL,
  `user_pwd` varchar(100) DEFAULT NULL,
  `user_type_cd` varchar(2) DEFAULT '02',
  `user_gender` varchar(5) DEFAULT NULL COMMENT '01:남자 02:여자',
  `user_birth` varchar(10) DEFAULT NULL,
  `reg_date` datetime DEFAULT current_timestamp(),
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK_AUTH_ID` (`auth_id`),
  CONSTRAINT `FK_AUTH_ID` FOREIGN KEY (`auth_id`) REFERENCES `user_auth` (`auth_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 travel.user:~5 rows (대략적) 내보내기
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`user_id`, `auth_id`, `user_addr`, `user_daddr`, `user_cp`, `user_email`, `user_grade`, `user_name`, `user_pwd`, `user_type_cd`, `user_gender`, `user_birth`, `reg_date`, `update_date`) VALUES
	('', '02', '(63534)제주특별자치도 서귀포시 가가로 14', '', '', '', NULL, '', 'e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855', '02', 'male', '2023-08-10', '2023-08-16 07:30:18', NULL),
	('admin', '01', NULL, NULL, NULL, NULL, 'A', NULL, '5994471ABB01112AFCC18159F6CC74B4F511B99806DA59B3CAF5A9C173CACFC5', '01', NULL, NULL, '2023-08-09 16:16:08', NULL),
	('rain', '02', '경기도안산', '이게될까', '01000000000', 'rain@tan.com', NULL, '이게될까', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', '02', 'male', '', NULL, NULL),
	('rain12', '02', '경기도안산시단원구', '선부동', '010000000000', 'oopop@naver.com', NULL, '김재규', '123456', '02', 'male', '', NULL, NULL),
	('test00', '02', '경기도', '시흥', '00000000000', 'test@test.com', NULL, '김재규', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', '02', 'male', '', NULL, NULL),
	('testing', '02', NULL, NULL, NULL, NULL, NULL, NULL, '12345', '02', NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- 테이블 travel.user_auth 구조 내보내기
CREATE TABLE IF NOT EXISTS `user_auth` (
  `auth_id` varchar(2) NOT NULL,
  `auth_name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`auth_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 travel.user_auth:~2 rows (대략적) 내보내기
DELETE FROM `user_auth`;
/*!40000 ALTER TABLE `user_auth` DISABLE KEYS */;
INSERT INTO `user_auth` (`auth_id`, `auth_name`) VALUES
	('01', 'ROLE_ADMIN'),
	('02', 'ROLE_USER');
/*!40000 ALTER TABLE `user_auth` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
