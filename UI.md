import { useState } from "react";

// ============================================================
// AI IMPLEMENTATION GUIDE
// ============================================================
// MINIMAL DUAL-MODE DESIGN SYSTEM — NO COLOR ACCENTS
//
// DARK MODE:
//   bg:             #0A0A0A
//   surface:        #141414
//   surfaceRaised:  #1C1C1C
//   border:         #262626
//   textPrimary:    #F5F5F5
//   textSecondary:  #888888
//   textMuted:      #444444
//   accentFg:       #FFFFFF   (CTA text, active icons)
//   accentBg:       #FFFFFF   (CTA button fill)
//   accentBgAlpha:  #FFFFFF14 (subtle tinted bg)
//   accentBtnText:  #0A0A0A   (text on filled CTA buttons)
//   danger:         #FF4444
//
// LIGHT MODE:
//   bg:             #F7F7F7
//   surface:        #FFFFFF
//   surfaceRaised:  #EFEFEF
//   border:         #E2E2E2
//   textPrimary:    #0A0A0A
//   textSecondary:  #666666
//   textMuted:      #BBBBBB
//   accentFg:       #0A0A0A
//   accentBg:       #0A0A0A
//   accentBgAlpha:  #0A0A0A10
//   accentBtnText:  #F7F7F7
//   danger:         #D93030
//
// Philosophy: ZERO hue. Pure contrast hierarchy.
// Hierarchy via weight, size, and opacity only.
// Fonts: Sora (headings) / DM Sans (body) / JetBrains Mono (CJK)
// Radii: 14px cards, 10px inputs, 100px pills
// ============================================================

const themes = {
  dark: {
    bg: "#0A0A0A",
    surface: "#141414",
    surfaceRaised: "#1C1C1C",
    border: "#262626",
    textPrimary: "#F5F5F5",
    textSecondary: "#888888",
    textMuted: "#444444",
    accentFg: "#FFFFFF",
    accentBg: "#FFFFFF",
    accentBgAlpha: "#FFFFFF14",
    accentBtnText: "#0A0A0A",
    danger: "#FF4444",
  },
  light: {
    bg: "#F7F7F7",
    surface: "#FFFFFF",
    surfaceRaised: "#EFEFEF",
    border: "#E2E2E2",
    textPrimary: "#0A0A0A",
    textSecondary: "#666666",
    textMuted: "#BBBBBB",
    accentFg: "#0A0A0A",
    accentBg: "#0A0A0A",
    accentBgAlpha: "#0A0A0A10",
    accentBtnText: "#F7F7F7",
    danger: "#D93030",
  },
};

const tabs = ["Upload", "Library", "Study", "Settings"];
const tabIcons = {
  Upload: (active) => (
    <svg width="22" height="22" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth={active ? 2.2 : 1.6}>
      <rect x="3" y="3" width="18" height="18" rx="3"/>
      <path d="M9 12l3-3 3 3M12 9v6"/>
    </svg>
  ),
  Library: (active) => (
    <svg width="22" height="22" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth={active ? 2.2 : 1.6}>
      <path d="M4 19V5a2 2 0 012-2h12a2 2 0 012 2v14"/>
      <path d="M8 21h8M12 17v4"/>
    </svg>
  ),
  Study: (active) => (
    <svg width="22" height="22" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth={active ? 2.2 : 1.6}>
      <rect x="2" y="5" width="20" height="14" rx="2"/>
      <path d="M8 5V3M16 5V3M2 10h20"/>
    </svg>
  ),
  Settings: (active) => (
    <svg width="22" height="22" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth={active ? 2.2 : 1.6}>
      <circle cx="12" cy="12" r="3"/>
      <path d="M12 2v2M12 20v2M4.22 4.22l1.42 1.42M18.36 18.36l1.42 1.42M2 12h2M20 12h2M4.22 19.78l1.42-1.42M18.36 5.64l1.42-1.42"/>
    </svg>
  ),
};

function UploadScreen({ c }) {
  return (
    <div style={{ padding: "24px 20px", display: "flex", flexDirection: "column", gap: 24 }}>
      <div style={{ display: "flex", justifyContent: "space-between", alignItems: "flex-start" }}>
        <div>
          <h1 style={{ fontFamily: "Sora", fontSize: 26, fontWeight: 700, color: c.textPrimary, lineHeight: 1.2, margin: 0 }}>
            Scan & Study
          </h1>
          <p style={{ fontFamily: "DM Sans", fontSize: 14, color: c.textSecondary, marginTop: 4, marginBottom: 0 }}>
            Photo → reader, glossary, flashcards
          </p>
        </div>
        <button style={{
          background: c.surfaceRaised, border: `1px solid ${c.border}`,
          borderRadius: 10, padding: "8px 14px", color: c.textSecondary,
          fontFamily: "DM Sans", fontSize: 13, display: "flex", alignItems: "center", gap: 6, cursor: "pointer"
        }}>
          <svg width="15" height="15" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2">
            <path d="M23 19a2 2 0 01-2 2H3a2 2 0 01-2-2V8a2 2 0 012-2h4l2-3h6l2 3h4a2 2 0 012 2z"/>
            <circle cx="12" cy="13" r="4"/>
          </svg>
          Live
        </button>
      </div>

      <div style={{
        background: c.surface, border: `1.5px dashed ${c.border}`,
        borderRadius: 18, padding: "52px 24px", textAlign: "center",
        cursor: "pointer", display: "flex", flexDirection: "column", alignItems: "center", gap: 18
      }}>
        <div style={{
          width: 56, height: 56, borderRadius: 16, background: c.accentBgAlpha,
          display: "flex", alignItems: "center", justifyContent: "center"
        }}>
          <svg width="24" height="24" viewBox="0 0 24 24" fill="none" stroke={c.accentFg} strokeWidth="1.8">
            <path d="M21 15v4a2 2 0 01-2 2H5a2 2 0 01-2-2v-4"/>
            <polyline points="17 8 12 3 7 8"/>
            <line x1="12" y1="3" x2="12" y2="15"/>
          </svg>
        </div>
        <div>
          <div style={{ fontFamily: "Sora", fontSize: 17, fontWeight: 600, color: c.textPrimary }}>Choose a photo</div>
          <div style={{ fontFamily: "DM Sans", fontSize: 13, color: c.textSecondary, marginTop: 4 }}>
            Screenshots, signs, menus — any text
          </div>
        </div>
        <div style={{
          background: c.accentBg, color: c.accentBtnText,
          fontFamily: "DM Sans", fontWeight: 700, fontSize: 15,
          padding: "12px 36px", borderRadius: 100, cursor: "pointer"
        }}>
          Pick Image
        </div>
      </div>

      <div style={{ display: "flex", gap: 8 }}>
        {[{ label: "Input", value: "Auto detect" }, { label: "Output", value: "English" }].map((chip) => (
          <button key={chip.label} style={{
            background: c.surface, border: `1px solid ${c.border}`,
            borderRadius: 100, padding: "7px 14px", cursor: "pointer",
            display: "flex", alignItems: "center", gap: 6
          }}>
            <span style={{ fontFamily: "DM Sans", fontSize: 12, color: c.textSecondary }}>{chip.label}</span>
            <span style={{ fontFamily: "DM Sans", fontSize: 12, color: c.textPrimary, fontWeight: 600 }}>{chip.value}</span>
            <svg width="10" height="10" viewBox="0 0 24 24" fill="none" stroke={c.textMuted} strokeWidth="3">
              <polyline points="6 9 12 15 18 9"/>
            </svg>
          </button>
        ))}
      </div>

      <div>
        <div style={{ fontFamily: "DM Sans", fontSize: 11, fontWeight: 600, color: c.textMuted, marginBottom: 10, textTransform: "uppercase", letterSpacing: "0.08em" }}>
          Recent
        </div>
        <div style={{ display: "flex", gap: 10 }}>
          {["请等我分钟", "原油主连交易中"].map((title) => (
            <div key={title} style={{
              background: c.surface, border: `1px solid ${c.border}`,
              borderRadius: 12, padding: "12px 14px", flex: 1, cursor: "pointer"
            }}>
              <div style={{ fontFamily: "JetBrains Mono", fontSize: 13, color: c.textPrimary, marginBottom: 3 }}>{title.slice(0, 5)}…</div>
              <div style={{ fontFamily: "DM Sans", fontSize: 11, color: c.textSecondary }}>Open reader →</div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}

function LibraryScreen({ c }) {
  const [search, setSearch] = useState("");
  const items = [
    { title: "请等我分钟", saved: "22 Apr, 19:23", cards: 29, preview: "Customer Service · 请等我2分钟..." },
    { title: "原油主连交易中", saved: "22 Apr, 19:20", cards: 45, preview: "FUT WTI原油主连 2605 · 交易中..." },
  ];
  return (
    <div style={{ padding: "24px 20px", display: "flex", flexDirection: "column", gap: 20 }}>
      <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center" }}>
        <h1 style={{ fontFamily: "Sora", fontSize: 26, fontWeight: 700, color: c.textPrimary, margin: 0 }}>Library</h1>
        <button style={{ background: "transparent", border: "none", color: c.textSecondary, cursor: "pointer", fontFamily: "DM Sans", fontSize: 13 }}>
          Sort ↕
        </button>
      </div>

      <div style={{
        background: c.surface, border: `1px solid ${c.border}`,
        borderRadius: 10, padding: "0 14px", display: "flex", alignItems: "center", gap: 10
      }}>
        <svg width="15" height="15" viewBox="0 0 24 24" fill="none" stroke={c.textMuted} strokeWidth="2">
          <circle cx="11" cy="11" r="8"/><path d="M21 21l-4.35-4.35"/>
        </svg>
        <input
          value={search}
          onChange={e => setSearch(e.target.value)}
          placeholder="Search saved scans…"
          style={{
            background: "transparent", border: "none", outline: "none",
            fontFamily: "DM Sans", fontSize: 14, color: c.textPrimary,
            padding: "12px 0", flex: 1
          }}
        />
      </div>

      {items.map((item) => (
        <div key={item.title} style={{
          background: c.surface, border: `1px solid ${c.border}`,
          borderRadius: 14, overflow: "hidden"
        }}>
          <div style={{ padding: "16px 18px" }}>
            <div style={{ display: "flex", justifyContent: "space-between", alignItems: "flex-start", marginBottom: 6 }}>
              <span style={{ fontFamily: "JetBrains Mono", fontSize: 18, fontWeight: 700, color: c.textPrimary }}>
                {item.title}
              </span>
              <span style={{
                background: c.accentBgAlpha, color: c.accentFg,
                fontFamily: "DM Sans", fontSize: 12, fontWeight: 600,
                padding: "3px 10px", borderRadius: 100
              }}>
                {item.cards} cards
              </span>
            </div>
            <div style={{ fontFamily: "DM Sans", fontSize: 12, color: c.textMuted, marginBottom: 8 }}>
              Saved {item.saved}
            </div>
            <div style={{ fontFamily: "DM Sans", fontSize: 13, color: c.textSecondary, lineHeight: 1.5 }}>
              {item.preview}
            </div>
          </div>
          <div style={{ display: "flex", borderTop: `1px solid ${c.border}` }}>
            <button style={{
              flex: 1, padding: "12px", background: "transparent", border: "none",
              fontFamily: "DM Sans", fontSize: 14, fontWeight: 600, color: c.accentFg,
              cursor: "pointer", borderRight: `1px solid ${c.border}`
            }}>
              Open Reader
            </button>
            <button style={{
              flex: 1, padding: "12px", background: "transparent", border: "none",
              fontFamily: "DM Sans", fontSize: 14, fontWeight: 500, color: c.textSecondary, cursor: "pointer"
            }}>
              Flashcards →
            </button>
          </div>
        </div>
      ))}
    </div>
  );
}

function StudyScreen({ c }) {
  const decks = [
    { title: "请等我分钟", cards: 29, mastered: 12, saved: "22 Apr", preview: ["请", "等", "分钟"], lang: "ZH" },
    { title: "原油主连交易中", cards: 45, mastered: 3, saved: "22 Apr", preview: ["原油", "交易", "最低"], lang: "ZH" },
  ];
  return (
    <div style={{ padding: "24px 20px", display: "flex", flexDirection: "column", gap: 20 }}>
      <h1 style={{ fontFamily: "Sora", fontSize: 26, fontWeight: 700, color: c.textPrimary, margin: 0 }}>Study</h1>

      <div style={{
        background: c.accentBgAlpha, border: `1px solid ${c.border}`,
        borderRadius: 14, padding: "14px 18px",
        display: "flex", justifyContent: "space-between", alignItems: "center"
      }}>
        <div>
          <div style={{ fontFamily: "Sora", fontSize: 15, fontWeight: 600, color: c.textPrimary }}>17 cards due today</div>
          <div style={{ fontFamily: "DM Sans", fontSize: 12, color: c.textSecondary, marginTop: 2 }}>Across 2 decks</div>
        </div>
        <button style={{
          background: c.accentBg, color: c.accentBtnText,
          fontFamily: "DM Sans", fontWeight: 700, fontSize: 13,
          padding: "8px 16px", borderRadius: 100, border: "none", cursor: "pointer"
        }}>
          Review now
        </button>
      </div>

      {decks.map((deck) => {
        const pct = Math.round((deck.mastered / deck.cards) * 100);
        return (
          <div key={deck.title} style={{
            background: c.surface, border: `1px solid ${c.border}`,
            borderRadius: 14, padding: "18px", display: "flex", flexDirection: "column", gap: 14
          }}>
            <div>
              <span style={{
                background: c.surfaceRaised, color: c.textSecondary,
                fontFamily: "DM Sans", fontSize: 11, fontWeight: 700,
                padding: "2px 8px", borderRadius: 6, display: "inline-block"
              }}>
                {deck.lang}
              </span>
              <div style={{ fontFamily: "JetBrains Mono", fontSize: 17, fontWeight: 700, color: c.textPrimary, marginTop: 6 }}>
                {deck.title}
              </div>
              <div style={{ fontFamily: "DM Sans", fontSize: 12, color: c.textMuted, marginTop: 2 }}>
                {deck.cards} cards · Saved {deck.saved}
              </div>
            </div>

            <div style={{ display: "flex", gap: 8, alignItems: "center" }}>
              {deck.preview.map((word) => (
                <span key={word} style={{
                  background: c.surfaceRaised, border: `1px solid ${c.border}`,
                  borderRadius: 8, padding: "4px 10px",
                  fontFamily: "JetBrains Mono", fontSize: 13, color: c.textSecondary
                }}>
                  {word}
                </span>
              ))}
              <span style={{ fontFamily: "DM Sans", fontSize: 12, color: c.textMuted }}>+{deck.cards - 3} more</span>
            </div>

            <div>
              <div style={{ display: "flex", justifyContent: "space-between", marginBottom: 6 }}>
                <span style={{ fontFamily: "DM Sans", fontSize: 12, color: c.textSecondary }}>{deck.mastered} mastered</span>
                <span style={{ fontFamily: "DM Sans", fontSize: 12, color: c.textPrimary, fontWeight: 600 }}>{pct}%</span>
              </div>
              <div style={{ background: c.surfaceRaised, borderRadius: 100, height: 4 }}>
                <div style={{ background: c.accentBg, borderRadius: 100, height: 4, width: `${pct}%` }} />
              </div>
            </div>

            <div style={{ display: "flex", gap: 10 }}>
              <button style={{
                flex: 2, padding: "11px", background: c.accentBg, border: "none",
                borderRadius: 10, fontFamily: "DM Sans", fontWeight: 700, fontSize: 14,
                color: c.accentBtnText, cursor: "pointer"
              }}>
                Start Flashcards
              </button>
              <button style={{
                flex: 1, padding: "11px", background: c.surfaceRaised,
                border: `1px solid ${c.border}`, borderRadius: 10,
                fontFamily: "DM Sans", fontSize: 13, color: c.textSecondary, cursor: "pointer"
              }}>
                Hard only
              </button>
            </div>
          </div>
        );
      })}
    </div>
  );
}

function SettingsScreen({ c, dark, setDark }) {
  const [autoOpen, setAutoOpen] = useState(true);
  const [spaced, setSpaced] = useState(false);

  const Toggle = ({ on, onToggle }) => (
    <div onClick={onToggle} style={{
      width: 44, height: 26, borderRadius: 100,
      background: on ? c.accentBg : c.surfaceRaised,
      border: `1px solid ${on ? c.accentBg : c.border}`,
      position: "relative", cursor: "pointer", transition: "background 0.2s",
      flexShrink: 0,
    }}>
      <div style={{
        position: "absolute", top: 3, left: on ? 20 : 3,
        width: 18, height: 18, borderRadius: "50%",
        background: on ? c.accentBtnText : c.textMuted,
        transition: "left 0.2s"
      }} />
    </div>
  );

  const Row = ({ icon, label, sub, right, last }) => (
    <div style={{
      display: "flex", alignItems: "center", gap: 14,
      padding: "14px 0",
      borderBottom: last ? "none" : `1px solid ${c.border}`
    }}>
      <div style={{
        width: 34, height: 34, borderRadius: 9, background: c.surfaceRaised,
        display: "flex", alignItems: "center", justifyContent: "center", flexShrink: 0
      }}>
        {icon}
      </div>
      <div style={{ flex: 1 }}>
        <div style={{ fontFamily: "DM Sans", fontSize: 14, fontWeight: 600, color: c.textPrimary }}>{label}</div>
        {sub && <div style={{ fontFamily: "DM Sans", fontSize: 12, color: c.textSecondary, marginTop: 2 }}>{sub}</div>}
      </div>
      {right}
    </div>
  );

  const Chevron = () => (
    <svg width="15" height="15" viewBox="0 0 24 24" fill="none" stroke={c.textMuted} strokeWidth="2">
      <polyline points="9 18 15 12 9 6"/>
    </svg>
  );

  const Section = ({ label }) => (
    <div style={{ fontFamily: "DM Sans", fontSize: 11, fontWeight: 600, color: c.textMuted, padding: "14px 0 2px", textTransform: "uppercase", letterSpacing: "0.08em" }}>
      {label}
    </div>
  );

  return (
    <div style={{ padding: "24px 20px", display: "flex", flexDirection: "column", gap: 16 }}>
      <h1 style={{ fontFamily: "Sora", fontSize: 26, fontWeight: 700, color: c.textPrimary, margin: 0 }}>Settings</h1>

      <div style={{ background: c.surface, borderRadius: 14, padding: "0 16px" }}>
        <Section label="Appearance" />
        <Row
          icon={<svg width="15" height="15" viewBox="0 0 24 24" fill="none" stroke={c.textSecondary} strokeWidth="2"><circle cx="12" cy="12" r="5"/><path d="M12 1v2M12 21v2M4.22 4.22l1.42 1.42M18.36 18.36l1.42 1.42M1 12h2M21 12h2M4.22 19.78l1.42-1.42M18.36 5.64l1.42-1.42"/></svg>}
          label="Dark mode"
          sub="Switch between light and dark"
          right={<Toggle on={dark} onToggle={() => setDark(!dark)} />}
          last
        />
      </div>

      <div style={{ background: c.surface, borderRadius: 14, padding: "0 16px" }}>
        <Section label="Languages" />
        <Row
          icon={<svg width="15" height="15" viewBox="0 0 24 24" fill="none" stroke={c.textSecondary} strokeWidth="2"><path d="M3 5h12M9 3v2M5 7l6 6M7 11l-2 6"/><path d="M13 5s-4 5-4 11M15 19l2-5 2 5M18.5 17h-3"/></svg>}
          label="Input language"
          sub="Auto detect"
          right={<Chevron />}
        />
        <Row
          icon={<svg width="15" height="15" viewBox="0 0 24 24" fill="none" stroke={c.textSecondary} strokeWidth="2"><circle cx="12" cy="12" r="10"/><path d="M2 12h20M12 2a15.3 15.3 0 010 20"/></svg>}
          label="Output language"
          sub="English"
          right={<Chevron />}
          last
        />
      </div>

      <div style={{ background: c.surface, borderRadius: 14, padding: "0 16px" }}>
        <Section label="Reader & Upload" />
        <Row
          icon={<svg width="15" height="15" viewBox="0 0 24 24" fill="none" stroke={c.textSecondary} strokeWidth="2"><path d="M2 3h6a4 4 0 014 4v14a3 3 0 00-3-3H2z"/><path d="M22 3h-6a4 4 0 00-4 4v14a3 3 0 013-3h7z"/></svg>}
          label="Auto-open reader"
          sub="Jump straight to reader after scan"
          right={<Toggle on={autoOpen} onToggle={() => setAutoOpen(!autoOpen)} />}
        />
        <Row
          icon={<svg width="15" height="15" viewBox="0 0 24 24" fill="none" stroke={c.textSecondary} strokeWidth="2"><rect x="3" y="4" width="18" height="18" rx="2"/><path d="M16 2v4M8 2v4M3 10h18"/></svg>}
          label="Spaced repetition"
          sub="Schedule reviews by difficulty"
          right={<Toggle on={spaced} onToggle={() => setSpaced(!spaced)} />}
          last
        />
      </div>

      <div style={{ background: c.surface, borderRadius: 14, padding: "0 16px" }}>
        <Section label="Data" />
        <Row
          icon={<svg width="15" height="15" viewBox="0 0 24 24" fill="none" stroke={c.textSecondary} strokeWidth="2"><path d="M21 15v4a2 2 0 01-2 2H5a2 2 0 01-2-2v-4"/><polyline points="7 10 12 15 17 10"/><line x1="12" y1="15" x2="12" y2="3"/></svg>}
          label="Export all decks"
          sub="Save as CSV or JSON"
          right={<Chevron />}
        />
        <Row
          icon={<svg width="15" height="15" viewBox="0 0 24 24" fill="none" stroke={c.danger} strokeWidth="2"><polyline points="3 6 5 6 21 6"/><path d="M19 6l-1 14a2 2 0 01-2 2H8a2 2 0 01-2-2L5 6"/><path d="M10 11v6M14 11v6"/></svg>}
          label="Clear all data"
          sub="Delete all scans and flashcards"
          right={<Chevron />}
          last
        />
      </div>

      <div style={{ height: 20 }} />
    </div>
  );
}

function TabBar({ active, setActive, c }) {
  return (
    <div style={{
      position: "fixed", bottom: 0,
      width: "100%", maxWidth: 430,
      background: c.surface,
      borderTop: `1px solid ${c.border}`,
      display: "flex",
      paddingBottom: 16,
    }}>
      {tabs.map((tab) => {
        const isActive = active === tab;
        return (
          <button
            key={tab}
            onClick={() => setActive(tab)}
            style={{
              flex: 1, background: "transparent", border: "none",
              display: "flex", flexDirection: "column", alignItems: "center",
              gap: 4, padding: "12px 0 4px", cursor: "pointer",
              color: isActive ? c.accentFg : c.textMuted,
              transition: "color 0.15s",
            }}
          >
            <div style={{
              background: isActive ? c.accentBgAlpha : "transparent",
              borderRadius: 10, padding: "4px 14px",
              transition: "background 0.15s",
            }}>
              {tabIcons[tab](isActive)}
            </div>
            <span style={{ fontFamily: "DM Sans", fontSize: 11, fontWeight: isActive ? 700 : 400 }}>
              {tab}
            </span>
          </button>
        );
      })}
    </div>
  );
}

export default function App() {
  const [activeTab, setActiveTab] = useState("Upload");
  const [dark, setDark] = useState(true);
  const c = dark ? themes.dark : themes.light;

  const screens = {
    Upload: <UploadScreen c={c} />,
    Library: <LibraryScreen c={c} />,
    Study: <StudyScreen c={c} />,
    Settings: <SettingsScreen c={c} dark={dark} setDark={setDark} />,
  };

  return (
    <div style={{
      background: c.bg,
      minHeight: "100vh",
      maxWidth: 430,
      margin: "0 auto",
      position: "relative",
      transition: "background 0.25s",
    }}>
      <link href="https://fonts.googleapis.com/css2?family=Sora:wght@400;600;700&family=DM+Sans:wght@400;500;600;700&family=JetBrains+Mono:wght@400;700&display=swap" rel="stylesheet" />
      <div style={{ height: 44, background: c.bg }} />
      <div style={{ paddingBottom: 100 }}>
        {screens[activeTab]}
      </div>
      <TabBar active={activeTab} setActive={setActiveTab} c={c} />
    </div>
  );
}